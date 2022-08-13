package com.shoppingcart.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shoppingcart.models.Customer;


@CrossOrigin("*")
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	
	public Customer findCustomerByUsername(String username) ;
}
