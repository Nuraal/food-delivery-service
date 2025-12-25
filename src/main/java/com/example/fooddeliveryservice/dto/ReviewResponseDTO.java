package com.example.fooddeliveryservice.dto;

import lombok.Data;

@Data
public class ReviewResponseDTO {
    private Long id;
    private Long customerId;
    private Long restaurantId;
    private Integer score;
    private String comment;
}