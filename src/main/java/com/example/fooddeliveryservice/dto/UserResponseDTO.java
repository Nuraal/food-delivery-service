package com.example.fooddeliveryservice.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String email;
    private String fullName;
    private String role;
}