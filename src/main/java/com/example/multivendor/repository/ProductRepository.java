package com.example.multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multivendor.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
