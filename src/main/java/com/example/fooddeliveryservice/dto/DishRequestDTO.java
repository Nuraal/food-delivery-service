package com.example.fooddeliveryservice.dto;

import lombok.Data;

@Data
public class DishRequestDTO {
    private String name;
    private Double price;
    private Long restaurantId;
}
