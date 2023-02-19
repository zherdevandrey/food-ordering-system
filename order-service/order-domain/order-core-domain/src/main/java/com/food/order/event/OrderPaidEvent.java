package com.food.order.event;

import com.food.order.entity.Order;

import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent {


    public OrderPaidEvent(Order order, ZonedDateTime utc) {
        super(order, utc);
    }


}
