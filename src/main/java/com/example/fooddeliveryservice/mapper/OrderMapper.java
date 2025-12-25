package com.example.fooddeliveryservice.mapper;

import com.example.fooddeliveryservice.dto.OrderRequestDTO;
import com.example.fooddeliveryservice.dto.OrderResponseDTO;
import com.example.fooddeliveryservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderMapper {
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "courier.id", target = "courierId")
    OrderResponseDTO toResponseDto(Order order);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(target = "totalPrice", ignore = true)
    Order toEntity(OrderRequestDTO dto);
}