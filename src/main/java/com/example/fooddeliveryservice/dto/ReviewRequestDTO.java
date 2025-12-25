package com.example.fooddeliveryservice.dto;

import lombok.Data;

@Data
public class ReviewRequestDTO {
    private Long customerId;
    private Long restaurantId;
    private Integer score;
    private String comment;
}

