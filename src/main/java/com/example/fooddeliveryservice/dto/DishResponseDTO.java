package com.example.fooddeliveryservice.dto;

import lombok.Data;

@Data
public class DishResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private Long restaurantId;
}