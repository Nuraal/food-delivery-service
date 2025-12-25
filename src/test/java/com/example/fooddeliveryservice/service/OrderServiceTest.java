package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.entity.Order;
import com.example.fooddeliveryservice.entity.OrderStatus;
import com.example.fooddeliveryservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void updateStatusTest() {
        Order order = new Order();
        order.setId(1L);
        order.setStatus(OrderStatus.PENDING);

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenAnswer(i -> i.getArguments()[0]);

        Order updated = orderService.updateStatus(1L, OrderStatus.DELIVERED); // Сенің сервисіңдегі метод аты

        assertEquals(OrderStatus.DELIVERED, updated.getStatus());
        verify(orderRepository).save(any(Order.class));
    }
}