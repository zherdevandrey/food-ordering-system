package com.food.order.event.publisher;

import com.food.order.event.DomainEvent;

public interface DomainEventPublisher <T extends DomainEvent> {
    void publish(T event);
}
