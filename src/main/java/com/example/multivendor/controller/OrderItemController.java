package com.example.multivendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.multivendor.entity.OrderItem;
import com.example.multivendor.service.OrderItemService;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @GetMapping
    public List<OrderItem> getAllOrderItem() {
        return service.getAllOrderItem();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrderItemById(id));
    }

    @PostMapping
    public ResponseEntity<OrderItem> save(@RequestBody OrderItem orderItem) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(orderItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id,
            @RequestBody OrderItem orderItem) {
        return ResponseEntity.ok(service.updateOrderItem(id, orderItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteOrderItem(id));
    }
}