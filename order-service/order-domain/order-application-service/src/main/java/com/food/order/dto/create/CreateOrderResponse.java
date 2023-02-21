package com.food.order.dto.create;

import  com.food.order.valueobject.OrderStatus;

import lombok.Builder;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Builder
public record CreateOrderResponse(@NotNull UUID orderTrackingId,
                                  @NotNull OrderStatus orderStatus,
                                  @NotNull String message) {
}