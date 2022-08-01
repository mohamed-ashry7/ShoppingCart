package com.shoppingcart.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	
	public Customer findCustomerByUsername(String username) ;
}
