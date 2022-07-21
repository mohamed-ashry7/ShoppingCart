package com.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.models.CustomerOrder;
import com.shoppingcart.repositories.CustomerOrderRepository;

@Service
public class CustomerOrderService {

	
	@Autowired
	private CustomerOrderRepository customerOrderRepository ; 
	
	
	public void createCustomerOrder(CustomerOrder co) { 
		this.customerOrderRepository.save(co) ; 
		
	}
}
