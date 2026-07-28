package com.example.multivendor.dto;

import lombok.Data;

@Data
public class OrderItemDto {

	 private int id;

	    private int quantity;

	    private double price;

	    private double subtotal;
}
