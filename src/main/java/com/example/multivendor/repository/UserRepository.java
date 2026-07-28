package com.example.multivendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multivendor.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
