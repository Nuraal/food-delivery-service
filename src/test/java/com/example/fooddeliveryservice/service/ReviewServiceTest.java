package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.entity.Review;
import com.example.fooddeliveryservice.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    void leaveReviewTest() {
        Review review = new Review();
        review.setComment("Good");
        when(reviewRepository.save(any(Review.class))).thenReturn(review);

        Review saved = reviewService.leaveReview(review); // Сенің сервисіңдегі метод аты

        assertNotNull(saved);
        assertEquals("Good", saved.getComment());
    }

    @Test
    void getRestaurantReviewsTest() {
        when(reviewRepository.findByRestaurantId(1L)).thenReturn(Arrays.asList(new Review()));

        List<Review> result = reviewService.getRestaurantReviews(1L);

        assertFalse(result.isEmpty());
    }
}