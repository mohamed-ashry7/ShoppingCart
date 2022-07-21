package com.shoppingcart.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
public @Data class Customer {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	private String city; 
	private String email;
	private String firstName ;
	private String lastName; 
	private String phone ;
	private String postalCode; 
	private String street;
	
	@OneToOne(targetEntity = Cart.class, cascade = CascadeType.ALL)
	private Cart cart =new Cart(); 
	
	
		
}
