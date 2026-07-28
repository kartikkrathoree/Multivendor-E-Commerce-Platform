package com.example.multivendor.dto;

import lombok.Data;

@Data
public class CustomerProfileDto {

	private int id;
	private String city;
	private String state;
	private String country;
	private String pincode;

}
