package com.training.Service;

import com.training.Dto.ActivityRequestDto;
import com.training.Dto.ActivityResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActivityService {
    ActivityResponseDto createActivity(ActivityRequestDto activityRequestDto);

    Page<ActivityResponseDto> getAllActivity(int page, int size, String sortBy, String sortDir);

    Page<ActivityResponseDto> getActivitiesByUser(Long userId,int page, int size, String sortBy, String sortDir);
}
