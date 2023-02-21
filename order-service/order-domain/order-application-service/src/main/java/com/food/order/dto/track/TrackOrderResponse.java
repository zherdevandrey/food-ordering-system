package com.food.order.dto.track;

import com.food.order.valueobject.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record TrackOrderResponse(@NotNull UUID orderTrackingId,
                                 @NotNull OrderStatus orderStatus,
                                 List<String> failureMessages) {
}
