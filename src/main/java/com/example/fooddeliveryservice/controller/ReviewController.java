package com.example.fooddeliveryservice.controller;

import com.example.fooddeliveryservice.dto.ReviewRequestDTO;
import com.example.fooddeliveryservice.dto.ReviewResponseDTO;
import com.example.fooddeliveryservice.entity.Review;
import com.example.fooddeliveryservice.mapper.ReviewMapper;
import com.example.fooddeliveryservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> leaveReview(@RequestBody ReviewRequestDTO dto) {
        Review review = reviewMapper.toEntity(dto);
        return ResponseEntity.ok(reviewMapper.toResponseDto(reviewService.leaveReview(review)));
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<ReviewResponseDTO>> getRestaurantReviews(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(reviewService.getRestaurantReviews(restaurantId).stream()
                .map(reviewMapper::toResponseDto)
                .collect(Collectors.toList()));
    }
}