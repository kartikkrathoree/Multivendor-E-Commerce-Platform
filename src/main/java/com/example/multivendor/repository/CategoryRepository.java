package com.example.multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multivendor.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
