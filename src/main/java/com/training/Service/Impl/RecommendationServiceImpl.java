package com.training.Service.Impl;

import com.training.Dto.RecommendationRequestDto;
import com.training.Dto.RecommendationResponseDto;
import com.training.Entity.Activity;
import com.training.Entity.Recommendation;
import com.training.Entity.User;
import com.training.Repo.ActivityRepo;
import com.training.Repo.RecommendationRepo;
import com.training.Repo.UserRepo;
import com.training.Service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepo recommendationRepo;
    private final ModelMapper modelMapper;
    private final UserRepo  userRepo;
    private final ActivityRepo activityRepo;


    @Override
    public RecommendationResponseDto generateRecommendation(RecommendationRequestDto dto) {

        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Activity activity = activityRepo.findById(dto.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        Recommendation recommendation = new Recommendation();

        recommendation.setType(dto.getType());
        recommendation.setRecommendation(dto.getRecommendation());
        recommendation.setImprovements(dto.getImprovements());
        recommendation.setSuggestions(dto.getSuggestions());
        recommendation.setSafety(dto.getSafety());

        recommendation.setUser(user);
        recommendation.setActivity(activity);

        Recommendation saved = recommendationRepo.save(recommendation);

        return modelMapper.map(saved, RecommendationResponseDto.class);
    }
}
