package com.example.multivendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multivendor.entity.Order;
import com.example.multivendor.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	public List<Order>getAllOrder(){
		return repo.findAll();
	}
	
	public Order save(Order order) {
		return repo.save(order);
	}
	
	public Order getOrderById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("order not found"));
	}
	
	public Order updateOrder(Long id, Order order) {
		Order existingOrder = getOrderById(id);
		existingOrder.setOrderItems(order.getOrderItems()); 
		existingOrder.setOrderDate(order.getOrderDate());
		existingOrder.setStatus(order.getStatus());
		existingOrder.setTotalAmount(order.getTotalAmount());
		
		return repo.save(existingOrder);
	}
	
	public String deleteOrder(Long id) {
    repo.deleteById(id);
    return "delete successfully";
}
}
