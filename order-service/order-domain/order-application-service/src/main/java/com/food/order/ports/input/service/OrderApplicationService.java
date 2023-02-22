package com.food.order.ports.input.service;

import com.food.order.dto.create.CreateOrderCommand;
import com.food.order.dto.create.CreateOrderResponse;
import com.food.order.dto.track.TrackOrderQuery;
import com.food.order.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
