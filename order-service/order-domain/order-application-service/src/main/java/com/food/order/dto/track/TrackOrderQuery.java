package com.food.order.dto.track;

import lombok.Builder;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Builder
public record TrackOrderQuery(@NotNull UUID orderTrackingId) {
}
