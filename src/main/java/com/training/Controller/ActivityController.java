package com.training.Controller;


import com.training.Dto.ActivityRequestDto;
import com.training.Dto.ActivityResponseDto;
import com.training.Entity.Activity;
import com.training.Service.ActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<ActivityResponseDto> createActivity(
            @Valid @RequestBody ActivityRequestDto dto) {

        ActivityResponseDto response = activityService.createActivity(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/activity")
    public ResponseEntity<List<ActivityResponseDto>> getAllActivity(){
        return ResponseEntity.ok(activityService.getAllActivity());
    }

    @GetMapping("/{userId}/activities")
    public ResponseEntity<List<ActivityResponseDto>> getUserActivities(
            @PathVariable Long userId) {

        return ResponseEntity.ok(activityService.getActivitiesByUser(userId));
    }
}
