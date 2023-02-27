package com.food.order;

import com.food.order.dto.track.TrackOrderQuery;
import com.food.order.dto.track.TrackOrderResponse;
import com.food.order.exception.OrderNotFoundException;
import com.food.order.mapper.OrderDataMapper;
import com.food.order.ports.output.OrderRepository;
import com.food.order.valueobject.TrackingId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderTrackCommandHandler {

    private final OrderDataMapper orderDataMapper;
    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        var order =  orderRepository.findByTrackingId
                        (new TrackingId(trackOrderQuery.orderTrackingId()))
                .orElseThrow(() -> new OrderNotFoundException
                        ("Order not found with tracking id : +  " + trackOrderQuery.orderTrackingId()));
        return orderDataMapper.orderToTrackOrderResponse(order);
    }
}
