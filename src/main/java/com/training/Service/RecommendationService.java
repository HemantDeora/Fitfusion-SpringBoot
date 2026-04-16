package com.training.Service;

import com.training.Dto.RecommendationRequestDto;
import com.training.Dto.RecommendationResponseDto;

import java.util.List;

public interface RecommendationService {
    RecommendationResponseDto generateRecommendation(RecommendationRequestDto recommendationRequestDto);

    List<RecommendationResponseDto> getRecommendationByUserID(Long userId);

    List<RecommendationResponseDto> getRecommendationByActivityID(Long activityId);
}
