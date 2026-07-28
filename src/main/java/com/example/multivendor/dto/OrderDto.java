package com.example.multivendor.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrderDto {

	private int id;

    private LocalDate orderDate;

    private double totalAmount;

    private String status;
	
}
