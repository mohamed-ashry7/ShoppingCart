package com.shoppingcart.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import lombok.Data;

@Entity
public @Data class CustomerOrder {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ; 
	
	private double totalPrice ; 
	private Date orderDate; 
	private String status ; 
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(targetEntity = CartItem.class)
	private List<CartItem> cartItems; 
	
	@PrePersist
	public void lastUpdated() {
		this.orderDate=new Date() ; 
	}
		
}
