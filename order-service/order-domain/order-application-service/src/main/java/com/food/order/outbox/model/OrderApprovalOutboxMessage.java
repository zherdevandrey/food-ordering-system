package com.food.order.outbox.model;

import com.food.order.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class OrderApprovalOutboxMessage {

    private UUID id;

    private UUID sagaId;

    private ZonedDateTime createdAt;

    @Setter
    private ZonedDateTime processedAt;

    private String type;

    private String payload;

    @Setter
    private OrderStatus orderStatus;

    private int version;
}
