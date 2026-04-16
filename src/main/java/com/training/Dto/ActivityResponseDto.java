package com.training.Dto;

import com.training.Entity.enums.ActivityType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityResponseDto {

    @NotNull
    private Long id;

    @NotNull
    private ActivityType activity;

    private int duration;
    private double caloriesBurned;
    private double distance;
    private int steps;

    private LocalDateTime startTime;
    private LocalDateTime createdAt;

    private Map<String, Object> additionalMetrics;
}