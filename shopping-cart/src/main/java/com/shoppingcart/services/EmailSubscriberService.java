package com.shoppingcart.services;


import org.springframework.stereotype.Service;

import com.shoppingcart.models.EmailSubscriber;
import com.shoppingcart.repositories.EmailSubscriberRepository;

@Service
public class EmailSubscriberService {

	
	
	private final EmailSubscriberRepository emailSubscriberRepository ; 
	
	
	
	public EmailSubscriberService(EmailSubscriberRepository emailSubscriberRepository) {
		this.emailSubscriberRepository = emailSubscriberRepository;
	}



	public void createEmailSubscriber(EmailSubscriber es ) { 
		
		emailSubscriberRepository.save(es);
	}
}
