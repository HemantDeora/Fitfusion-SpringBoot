package com.training.Dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RecommendationResponseDto {

    private Long id;
    private String type;
    private String recommendation;

    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}