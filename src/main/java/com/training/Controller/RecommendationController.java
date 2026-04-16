package com.training.Controller;

import com.training.Dto.RecommendationRequestDto;
import com.training.Dto.RecommendationResponseDto;
import com.training.Service.RecommendationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponseDto> generateRecommendation(@Valid  @RequestBody RecommendationRequestDto recommendationRequestDto) {
        return ResponseEntity.ok(recommendationService.generateRecommendation(recommendationRequestDto));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<RecommendationResponseDto>> getRecommendationByUserID(
            @PathVariable("id") Long userId) {

        return ResponseEntity.ok(recommendationService.getRecommendationByUserID(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<RecommendationResponseDto>> getRecommendationByActivityID(@PathVariable Long activityId) {
        return ResponseEntity.ok(recommendationService.getRecommendationByActivityID(activityId));
    }
}
