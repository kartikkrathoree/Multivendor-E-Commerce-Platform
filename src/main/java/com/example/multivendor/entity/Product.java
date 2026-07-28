package com.example.multivendor.entity;

	import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name = "product")
	public class Product {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String productName;

	    private String brand;

	    private Double price;

	    private Integer quantity;


	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    @JsonBackReference
	    private Category category;

	    @ManyToMany(mappedBy = "products")
	    private List<Cart> carts;

	}
	
