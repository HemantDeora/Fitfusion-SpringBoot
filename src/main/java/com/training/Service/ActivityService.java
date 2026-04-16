package com.training.Service;

import com.training.Dto.ActivityRequestDto;
import com.training.Dto.ActivityResponseDto;

import java.util.List;

public interface ActivityService {
    ActivityResponseDto createActivity(ActivityRequestDto activityRequestDto);

    List<ActivityResponseDto> getAllActivity();

    List<ActivityResponseDto> getActivitiesByUser(Long userId);
}
