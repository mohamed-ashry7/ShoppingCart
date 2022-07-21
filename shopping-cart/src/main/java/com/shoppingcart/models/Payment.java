package com.shoppingcart.models;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import lombok.Data;

@Entity
public @Data class Payment {

	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ; 
	
	
	private double amount ; 
	private String transactionId; 
	private Date paymentDate; 
	private String paymentStatus; 
	
	
	@ManyToOne
	private Customer customer;
	
	@OneToOne
	private CustomerOrder customerOrder ;
	
	@PrePersist
	public void lastUpdated() {
		this.paymentDate=new Date() ; 
	}
	
}
