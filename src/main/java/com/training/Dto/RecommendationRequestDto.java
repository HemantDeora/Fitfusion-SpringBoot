package com.training.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class RecommendationRequestDto {

    @NotNull(message = "UserId is required")
    private Long userId;

    @NotNull(message = "ActivityId is required")
    private Long activityId;

    @NotBlank(message = "Type is required")
    private String type;

    @NotBlank(message = "Recommendation text is required")
    @Size(max = 1500, message = "Recommendation too long")
    private String recommendation;

    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
}