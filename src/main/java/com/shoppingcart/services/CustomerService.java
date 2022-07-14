package com.shoppingcart.services;

import java.util.ArrayList;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.models.Customer;
import com.shoppingcart.repositories.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository ; 
	
	
	public List<Customer> getAllCustomers() { 
		
		List<Customer> customers = new ArrayList<>() ; 
		customerRepository.findAll().forEach(c -> customers.add(c));
		
		return customers; 
	}
	
	public Customer getCustomerById(int id ) { 
		
		
		Optional<Customer> op =   customerRepository.findById(id);
		if (op.isPresent()) {
			return op.get(); 
		}
		return null ; 
	}
	
	public void createCustomer (Customer c ) { 
		customerRepository.save(c) ; 
	}
	
	
}
