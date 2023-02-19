package com.food.order.event;

import com.food.order.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent {

    public OrderCancelledEvent(Order order, ZonedDateTime utc) {
        super(order, utc);
    }

}
