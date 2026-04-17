package com.training.Service.Impl;

import com.training.Dto.ActivityRequestDto;
import com.training.Dto.ActivityResponseDto;
import com.training.Entity.Activity;
import com.training.Entity.User;
import com.training.Repo.ActivityRepo;
import com.training.Repo.UserRepo;
import com.training.Service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepo activityRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    @Override
    public ActivityResponseDto createActivity(ActivityRequestDto dto) {

        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Activity activity = new Activity();

        activity.setActivity(dto.getActivity());
        activity.setDuration(dto.getDuration());
        activity.setCaloriesBurned(dto.getCaloriesBurned());
        activity.setDistance(dto.getDistance());
        activity.setSteps(dto.getSteps());
        activity.setStartTime(dto.getStartTime());
        activity.setAdditionalMetrics(dto.getAdditionalMetrics());
        activity.setUser(user);

        Activity savedActivity = activityRepo.save(activity);

        return modelMapper.map(savedActivity, ActivityResponseDto.class);
    }

    @Override
    public Page<ActivityResponseDto> getAllActivity(int page, int size, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Activity> activityPage = activityRepo.findAll(pageable);

        return activityPage.map(activity ->
                modelMapper.map(activity, ActivityResponseDto.class)
        );
    }

    @Override
    public Page<ActivityResponseDto> getActivitiesByUser(Long userId, int page, int size, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Activity> activityPage = activityRepo.findByUserId(userId, pageable);

        return activityPage.map(activity ->
                modelMapper.map(activity, ActivityResponseDto.class)
        );
    }
}