package com.example.fooddeliveryservice.dto;

import lombok.Data;

@Data
public class RestaurantResponseDTO {
    private Long id;
    private String name;
    private String address;
    private Double rating;
}