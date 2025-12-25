package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.entity.Dish;
import com.example.fooddeliveryservice.repository.DishRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DishServiceTest {

    @Mock
    private DishRepository dishRepository;

    @InjectMocks
    private DishService dishService;

    @Test
    void getDishesByRestaurantTest() {
        Dish dish = new Dish();
        dish.setName("Pizza");
        when(dishRepository.findByRestaurantId(1L)).thenReturn(Arrays.asList(dish));

        List<Dish> result = dishService.getDishesByRestaurant(1L);

        assertEquals(1, result.size());
        verify(dishRepository).findByRestaurantId(1L);
    }

    @Test
    void addDishTest() {
        Dish dish = new Dish();
        dish.setName("Burger");
        when(dishRepository.save(any(Dish.class))).thenReturn(dish);

        Dish saved = dishService.addDish(dish); // Сенің сервисіңдегі метод аты

        assertNotNull(saved);
        assertEquals("Burger", saved.getName());
    }
}