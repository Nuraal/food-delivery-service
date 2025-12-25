package com.example.fooddeliveryservice.dto;

import lombok.Data;

@Data
public class OrderItemRequestDTO {
    private Long dishId;
    private Integer quantity;
}
