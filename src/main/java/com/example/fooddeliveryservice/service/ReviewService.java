package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.entity.Review;
import com.example.fooddeliveryservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public Review leaveReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getRestaurantReviews(Long restaurantId) {
        return reviewRepository.findByRestaurantId(restaurantId);
    }
}