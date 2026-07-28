package com.example.multivendor.entity;


	import java.time.LocalDate;
	import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name = "orders")
	public class Order {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private LocalDate orderDate;

	    private Double totalAmount;

	    private String status;

	    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<OrderItem> orderItems;

}
