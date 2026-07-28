package com.example.multivendor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multivendor.entity.User;
import com.example.multivendor.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> getAllUser(){
		return repo.findAll();
	}
	
	public User save(User user) {
		if(user.getCustomerprofile() != null) {
			user.getCustomerprofile().setUser(user);
		}
		return repo.save(user);
	}
	
	public User getUserById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}
	public User updateUser(Long id, User user) {
		User existingUser = getUserById(id);
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setCustomerprofile(user.getCustomerprofile());
		
		return repo.save(existingUser);
		
	}
	public String deleteUser(Long id) {
		 repo.deleteById(id);
		 return "delete successfully";
	}
}

