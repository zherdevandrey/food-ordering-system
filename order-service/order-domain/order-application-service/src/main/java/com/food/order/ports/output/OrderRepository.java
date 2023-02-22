package com.food.order.ports.output;

import com.food.order.entity.Order;
import com.food.order.valueobject.OrderId;
import com.food.order.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(OrderId trackingId);

    Optional<Order> findByTrackingId(TrackingId trackingId);


}
