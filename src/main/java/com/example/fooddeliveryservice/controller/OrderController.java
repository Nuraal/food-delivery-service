package com.example.fooddeliveryservice.controller;

import com.example.fooddeliveryservice.dto.OrderRequestDTO;
import com.example.fooddeliveryservice.dto.OrderResponseDTO;
import com.example.fooddeliveryservice.entity.Order;
import com.example.fooddeliveryservice.entity.OrderStatus;
import com.example.fooddeliveryservice.mapper.OrderMapper;
import com.example.fooddeliveryservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> create(@RequestBody OrderRequestDTO dto) {
        Order order = orderMapper.toEntity(dto);
        return ResponseEntity.ok(orderMapper.toResponseDto(orderService.createOrder(order)));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderResponseDTO> updateStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderMapper.toResponseDto(orderService.updateStatus(id, status)));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderResponseDTO>> getCustomerOrders(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.getCustomerOrders(customerId).stream()
                .map(orderMapper::toResponseDto)
                .collect(Collectors.toList()));
    }
}