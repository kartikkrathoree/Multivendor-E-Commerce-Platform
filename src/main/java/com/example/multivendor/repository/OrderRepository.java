package com.example.multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multivendor.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
