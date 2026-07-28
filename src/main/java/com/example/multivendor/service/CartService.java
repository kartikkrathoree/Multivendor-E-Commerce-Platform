package com.example.multivendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multivendor.entity.Cart;
import com.example.multivendor.repository.CartRepository;

@Service
public class CartService {

	@Autowired
    private CartRepository repo;

    public List<Cart> getAllCart() {
        return repo.findAll();
    }

    public Cart save(Cart cart) {
        return repo.save(cart);
    }

    public Cart getCartById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public Cart updateCart(Long id, Cart cart) {

        Cart existingCart = getCartById(id);

        existingCart.setCartName(cart.getCartName());
        existingCart.setProducts(cart.getProducts());

        return repo.save(existingCart);
    }

    public String deleteCart(Long id) {
        repo.deleteById(id);
        return "Delete Successfully";
    }
}
