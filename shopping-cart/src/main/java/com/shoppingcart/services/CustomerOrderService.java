package com.shoppingcart.services;


import org.springframework.stereotype.Service;

import com.shoppingcart.models.CustomerOrder;
import com.shoppingcart.repositories.CustomerOrderRepository;

@Service
public class CustomerOrderService {

	
	
	private final CustomerOrderRepository customerOrderRepository ; 
	
	
	public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
		super();
		this.customerOrderRepository = customerOrderRepository;
	}


	public void createCustomerOrder(CustomerOrder co) { 
		this.customerOrderRepository.save(co) ; 
		
	}
}
