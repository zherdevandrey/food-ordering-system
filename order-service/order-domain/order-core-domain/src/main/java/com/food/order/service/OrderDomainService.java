package com.food.order.service;

import com.food.order.entity.Order;
import com.food.order.entity.Restaurant;
import com.food.order.event.OrderCancelledEvent;
import com.food.order.event.OrderCreatedEvent;
import com.food.order.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approve(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);

}
