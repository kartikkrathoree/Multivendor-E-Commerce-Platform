package com.example.multivendor.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.multivendor.entity.CustomerProfile;
import com.example.multivendor.service.CustomerProfileService;

@RestController
@RequestMapping("/customerprofile")
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService service;

    @GetMapping
    public List<CustomerProfile> getAllCustomerProfile() {
        return service.getAllCustomerProfile();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfile> getCustomerProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCustomerProfileById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerProfile> save(@RequestBody CustomerProfile cp) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(cp));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerProfile> updateCustomerProfile(@PathVariable Long id,
            @RequestBody CustomerProfile cp) {
        return ResponseEntity.ok(service.updateCustomerProfile(id, cp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerProfile(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteCustomerProfile(id));
    }
}