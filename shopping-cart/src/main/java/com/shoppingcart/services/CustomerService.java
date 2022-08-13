package com.shoppingcart.services;

import java.util.ArrayList;



import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoppingcart.models.Customer;
import com.shoppingcart.repositories.CustomerRepository;

@Service
public class CustomerService 
implements UserDetailsService
{

	
	private final CustomerRepository customerRepository;

	
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> getAllCustomers() {

		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(c -> customers.add(c));

		return customers;
	}

	public Customer getCustomerById(int id) {

		Optional<Customer> op = customerRepository.findById(id);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public Customer loadUserByUsername(String username) throws UsernameNotFoundException {

		Customer c = customerRepository.findCustomerByUsername(username);
		if (c != null) {
			return c;
		}
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

	public void createCustomer(Customer c) {
		customerRepository.save(c);
	}

}
