package com.example.multivendor.dto;

import lombok.Data;

@Data
public class ProductDto {

    private int id;
    private String productName;
    private String brand;
    private Double price;
    private int quantity;
    private int categoryId;

}