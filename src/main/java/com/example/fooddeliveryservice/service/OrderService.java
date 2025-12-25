package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.entity.Order;
import com.example.fooddeliveryservice.entity.OrderStatus;
import com.example.fooddeliveryservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public Order createOrder(Order order) {
        order.setStatus(OrderStatus.PENDING);
        double total = order.getItems().stream()
                .mapToDouble(item -> item.getDish().getPrice() * item.getQuantity())
                .sum();
        order.setTotalPrice(total);
        return orderRepository.save(order);
    }

    @Transactional
    public Order updateStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public List<Order> getCustomerOrders(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}