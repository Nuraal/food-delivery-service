package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant();
        restaurant.setId(1L);
        restaurant.setName("Mariko");
        restaurant.setAddress("Almaty");
    }

    @Test
    void getAllRestaurantsTest() {
        when(restaurantRepository.findAll()).thenReturn(Arrays.asList(restaurant));

        List<Restaurant> result = restaurantService.getAllRestaurants();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restaurantRepository, times(1)).findAll();
    }

    @Test
    void getByIdTest() {
        when(restaurantRepository.findById(1L)).thenReturn(Optional.of(restaurant));

        Restaurant result = restaurantService.getById(1L);

        assertNotNull(result);
        assertEquals("Mariko", result.getName());
    }

    @Test
    void saveRestaurantTest() {
        // Сенің сервисіңде метод аты: save
        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);

        Restaurant saved = restaurantService.save(restaurant);

        assertNotNull(saved);
        assertEquals("Mariko", saved.getName());
        verify(restaurantRepository, times(1)).save(restaurant);
    }
}