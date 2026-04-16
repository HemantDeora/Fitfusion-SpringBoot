package com.training.Controller;

import com.training.Dto.RecommendationRequestDto;
import com.training.Dto.RecommendationResponseDto;
import com.training.Service.RecommendationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponseDto> generateRecommendation(@Valid  @RequestBody RecommendationRequestDto recommendationRequestDto) {
        return ResponseEntity.ok(recommendationService.generateRecommendation(recommendationRequestDto));
    }
}
