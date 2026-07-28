package com.example.multivendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multivendor.entity.CustomerProfile;
import com.example.multivendor.repository.CustomerProfileRepository;


@Service
public class CustomerProfileService {

	@Autowired
	private CustomerProfileRepository repo;
	
	public List<CustomerProfile> getAllCustomerProfile(){
		return repo.findAll();
	}
	public CustomerProfile save(CustomerProfile cp) {
		return repo.save(cp);
	}
	public CustomerProfile getCustomerProfileById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("customerprofile not found"));
	}
	public CustomerProfile updateCustomerProfile(Long id, CustomerProfile cp) {
		CustomerProfile existingcp = getCustomerProfileById(id);
		existingcp.setCity(cp.getCity());
		existingcp.setState(cp.getState());
		existingcp.setCountry(cp.getCountry());
		existingcp.setPincode(cp.getPincode());
		
		return repo.save(existingcp);
	}
	public String deleteCustomerProfile(Long id) {
		repo.deleteById(id);
		return "delete successfully";
	}
}
