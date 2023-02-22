package com.food.order;

import com.food.order.dto.create.CreateOrderCommand;
import com.food.order.dto.create.CreateOrderResponse;
import com.food.order.dto.track.TrackOrderQuery;
import com.food.order.dto.track.TrackOrderResponse;
import com.food.order.ports.input.service.OrderApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Component
@RequiredArgsConstructor
class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderCreateCommandHandler orderCreateCommandHandler;
    private final OrderTrackCommandHandler orderTrackCommandHandler;

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        orderCreateCommandHandler.createOrder(createOrderCommand);
        return null;
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        orderTrackCommandHandler.trackOrder(trackOrderQuery);
        return null;
    }
}
