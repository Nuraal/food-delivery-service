package com.example.fooddeliveryservice.mapper;

import com.example.fooddeliveryservice.dto.ReviewRequestDTO;
import com.example.fooddeliveryservice.dto.ReviewResponseDTO;
import com.example.fooddeliveryservice.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "restaurant.id", target = "restaurantId")
    ReviewResponseDTO toResponseDto(Review review);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "restaurantId", target = "restaurant.id")
    Review toEntity(ReviewRequestDTO dto);
}