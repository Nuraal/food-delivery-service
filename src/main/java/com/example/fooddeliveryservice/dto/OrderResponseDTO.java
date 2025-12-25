package com.example.fooddeliveryservice.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderResponseDTO {
    private Long id;
    private Long customerId;
    private Long courierId;
    private Double totalPrice;
    private String status;
    private List<OrderItemResponseDTO> items;
}