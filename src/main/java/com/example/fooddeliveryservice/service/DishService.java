package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.entity.Dish;
import com.example.fooddeliveryservice.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    public List<Dish> getDishesByRestaurant(Long restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }

    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }
}