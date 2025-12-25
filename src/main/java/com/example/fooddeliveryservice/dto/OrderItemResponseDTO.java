package com.example.fooddeliveryservice.dto;

import lombok.Data;

@Data
public class OrderItemResponseDTO {
    private Long id;
    private Long dishId;
    private String dishName;
    private Integer quantity;
}