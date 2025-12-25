package com.example.fooddeliveryservice.mapper;

import com.example.fooddeliveryservice.dto.DishRequestDTO;
import com.example.fooddeliveryservice.dto.DishResponseDTO;
import com.example.fooddeliveryservice.entity.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DishMapper {
    @Mapping(source = "restaurant.id", target = "restaurantId")
    DishResponseDTO toResponseDto(Dish dish);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "restaurantId", target = "restaurant.id")
    Dish toEntity(DishRequestDTO dto);
}