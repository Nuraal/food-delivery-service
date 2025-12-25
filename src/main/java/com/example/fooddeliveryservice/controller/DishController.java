package com.example.fooddeliveryservice.controller;

import com.example.fooddeliveryservice.dto.DishRequestDTO;
import com.example.fooddeliveryservice.dto.DishResponseDTO;
import com.example.fooddeliveryservice.entity.Dish;
import com.example.fooddeliveryservice.mapper.DishMapper;
import com.example.fooddeliveryservice.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
    private final DishMapper dishMapper;

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<DishResponseDTO>> getByRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(dishService.getDishesByRestaurant(restaurantId).stream()
                .map(dishMapper::toResponseDto)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<DishResponseDTO> addDish(@RequestBody DishRequestDTO dto) {
        Dish dish = dishMapper.toEntity(dto);
        return ResponseEntity.ok(dishMapper.toResponseDto(dishService.addDish(dish)));
    }
}