package com.example.fooddeliveryservice.mapper;

import com.example.fooddeliveryservice.dto.RestaurantRequestDTO;
import com.example.fooddeliveryservice.dto.RestaurantResponseDTO;
import com.example.fooddeliveryservice.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantResponseDTO toResponseDto(Restaurant restaurant);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "menu", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    Restaurant toEntity(RestaurantRequestDTO dto);
}