package com.example.multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multivendor.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
