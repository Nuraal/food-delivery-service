package com.example.fooddeliveryservice.mapper;

import com.example.fooddeliveryservice.dto.UserRequestDTO;
import com.example.fooddeliveryservice.dto.UserResponseDTO;
import com.example.fooddeliveryservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toResponseDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orders", ignore = true)
    User toEntity(UserRequestDTO dto);
}