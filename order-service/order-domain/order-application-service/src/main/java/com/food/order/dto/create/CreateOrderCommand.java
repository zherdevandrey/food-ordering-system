package com.food.order.dto.create;

import com.food.order.entity.OrderItem;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CreateOrderCommand(@NotNull UUID customerId,
                                 @NotNull UUID restaurantId,
                                 @NotNull BigDecimal price,
                                 @NotNull List<OrderItem> orderItems,
                                 @NotNull OrderAddress orderAddress) {
}
