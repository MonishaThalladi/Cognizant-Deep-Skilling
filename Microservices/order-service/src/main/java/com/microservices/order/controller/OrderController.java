package com.microservices.order.controller;

import com.microservices.order.client.UserClient;
import com.microservices.order.entity.Order;
import com.microservices.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        // Verify user exists
        Map user = userClient.getUser(order.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found with id: " + order.getUserId());
        }
        order.setStatus("CREATED");
        return orderRepository.save(order);
    }
}
