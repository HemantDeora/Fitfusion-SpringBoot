package com.training.Controller;

import com.training.Dto.ActivityRequestDto;
import com.training.Dto.ActivityResponseDto;
import com.training.Service.ActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<ActivityResponseDto>> getAllActivity(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Page<ActivityResponseDto> response =
                activityService.getAllActivity(page, size, sortBy, sortDir);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/activities")
    public ResponseEntity<Page<ActivityResponseDto>> getUserActivities(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Page<ActivityResponseDto> response =
                activityService.getActivitiesByUser(userId, page, size, sortBy, sortDir);

        return ResponseEntity.ok(response);
    }
}