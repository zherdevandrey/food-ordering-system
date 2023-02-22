package com.food.order;

import com.food.order.dto.create.CreateOrderCommand;
import com.food.order.dto.create.CreateOrderResponse;
import com.food.order.entity.Customer;
import com.food.order.entity.Order;
import com.food.order.entity.Restaurant;
import com.food.order.event.OrderCreatedEvent;
import com.food.order.exception.OrderDomainException;
import com.food.order.mapper.OrderDataMapper;
import com.food.order.ports.output.CustomerRepository;
import com.food.order.ports.output.OrderRepository;
import com.food.order.ports.output.RestaurantRepository;
import com.food.order.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderCreateCommandHandler {

    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderDataMapper orderDataMapper;

    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.customerId());
        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant);
        Order saveOrder = saveOrder(order);
        log.info("Order created with id {}", saveOrder.getId().getValue());
        return orderDataMapper.orderToCreateOrderResponse(order);
    }


    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        Optional<Restaurant> optRestaurant = restaurantRepository.findRestaurantInformation(restaurant);
        if (optRestaurant.isEmpty()) {
            log.warn("Could not find restaurant with restaurant id: {}", createOrderCommand.restaurantId());
            throw new OrderDomainException("Could not find restaurant with restaurant id: " + createOrderCommand.restaurantId());
        }
        return optRestaurant.get();
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customerOpt = customerRepository.findCustomer(customerId);
        if (customerOpt.isEmpty()) {
            log.warn("Could not find customer with customer id: {}", customerId);
            throw new OrderDomainException("Could not find customer with customer id: " + customerId);
        }
    }

    private Order saveOrder(Order order) {
        Order orderResult = orderRepository.save(order);
        if (orderResult == null) {
            throw new OrderDomainException("Could not save order");
        }
        return orderResult;
    }
}
