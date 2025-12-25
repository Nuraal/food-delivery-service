package com.example.fooddeliveryservice.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String email;
    private String password;
    private String fullName;
    private String role;
}