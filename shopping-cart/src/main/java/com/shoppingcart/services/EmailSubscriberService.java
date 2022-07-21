package com.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.models.EmailSubscriber;
import com.shoppingcart.repositories.EmailSubscriberRepository;

@Service
public class EmailSubscriberService {

	
	@Autowired
	private EmailSubscriberRepository emailSubscriberRepository ; 
	
	public void createEmailSubscriber(EmailSubscriber es ) { 
		
		emailSubscriberRepository.save(es);
	}
}
