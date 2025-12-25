package com.example.fooddeliveryservice.mapper;

import com.example.fooddeliveryservice.dto.OrderItemRequestDTO;
import com.example.fooddeliveryservice.dto.OrderItemResponseDTO;
import com.example.fooddeliveryservice.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(source = "dish.id", target = "dishId")
    @Mapping(source = "dish.name", target = "dishName")
    OrderItemResponseDTO toResponseDto(OrderItem item);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true)
    @Mapping(source = "dishId", target = "dish.id")
    OrderItem toEntity(OrderItemRequestDTO dto);
}