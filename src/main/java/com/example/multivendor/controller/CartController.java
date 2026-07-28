package com.example.multivendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.multivendor.entity.Cart;
import com.example.multivendor.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping
    public List<Cart> getAllCart() {
        return service.getAllCart();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCartById(id));
    }

    @PostMapping
    public ResponseEntity<Cart> save(@RequestBody Cart cart) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(cart));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id,
            @RequestBody Cart cart) {
        return ResponseEntity.ok(service.updateCart(id, cart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteCart(id));
    }
}

	


