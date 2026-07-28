package com.example.multivendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multivendor.entity.Product;
import com.example.multivendor.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product>getAllProduct(){
		return repo.findAll();
	}
	
	public Product save(Product product) {
		return repo.save(product);
	}
	
	public Product getPRProductById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
	}
	
	public Product updateProduct(Long id, Product product) {
		Product existingProduct = getPRProductById(id);
		existingProduct.setProductName(product.getProductName());
		existingProduct.setBrand(product.getBrand());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setCarts(product.getCarts());
		
		return repo.save(existingProduct);
	}
	
	public String deleteProduct(Long id) {
    repo.deleteById(id);
    return "delete successfully";
}
}