package com.example.multivendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multivendor.entity.OrderItem;
import com.example.multivendor.repository.OrderItemRepository;

@Service
public class OrderItemService {
    
	@Autowired
	private OrderItemRepository repo;
	
	public List<OrderItem> getAllOrderItem(){
		return repo.findAll();
	}
	public OrderItem save(OrderItem item) {
		return repo.save(item);
	}
	public OrderItem getOrderItemById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("orderitem not found"));
	}
	public OrderItem updateOrderItem(Long id, OrderItem item) {
		OrderItem existingitem = getOrderItemById(id);
		existingitem.setPrice(item.getPrice());
		existingitem.setQuantity(item.getQuantity());
		existingitem.setSubtotal(item.getSubtotal());
		
		return repo.save(existingitem);
	}
	public String deleteOrderItem(Long id) {
		repo.deleteById(id);
		return "delete successfully";
	}	
}
