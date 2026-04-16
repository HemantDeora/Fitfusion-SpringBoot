package com.training.Dto;

import com.training.Entity.enums.ActivityType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityRequestDto {

    @NotNull(message = "UserId is required")
    private Long userId;

    @NotNull(message = "Activity type is required")
    private ActivityType activity;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    private int duration;

    @Positive(message = "Calories burned must be positive")
    private double caloriesBurned;

    @PositiveOrZero(message = "Distance cannot be negative")
    private double distance;

    @PositiveOrZero(message = "Steps cannot be negative")
    private int steps;

    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;

    private Map<String, Object> additionalMetrics;
}