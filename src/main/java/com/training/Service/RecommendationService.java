package com.training.Service;

import com.training.Dto.RecommendationRequestDto;
import com.training.Dto.RecommendationResponseDto;

public interface RecommendationService {
    RecommendationResponseDto generateRecommendation(RecommendationRequestDto recommendationRequestDto);
}
