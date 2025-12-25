package com.example.fooddeliveryservice.controller;

import com.example.fooddeliveryservice.dto.RestaurantRequestDTO;
import com.example.fooddeliveryservice.dto.RestaurantResponseDTO;
import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.mapper.RestaurantMapper;
import com.example.fooddeliveryservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    @GetMapping
    public ResponseEntity<List<RestaurantResponseDTO>> getAll() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants().stream()
                .map(restaurantMapper::toResponseDto)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<RestaurantResponseDTO> create(@RequestBody RestaurantRequestDTO dto) {
        Restaurant restaurant = restaurantMapper.toEntity(dto);
        return ResponseEntity.ok(restaurantMapper.toResponseDto(restaurantService.save(restaurant)));
    }
}