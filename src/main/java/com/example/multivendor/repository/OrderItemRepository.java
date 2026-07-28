package com.example.multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multivendor.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
