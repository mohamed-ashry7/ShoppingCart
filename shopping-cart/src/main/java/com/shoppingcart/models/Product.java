package com.shoppingcart.models;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Entity
public @Data class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	private String code ;
	private String description; 
	private String imageURL; 
	private int quantity; 
	private double price ;
	private Date lastUpdated; 
	
	@ManyToOne()
	private Category category ;

	@PrePersist
	@PreUpdate
	public void lastUpdated() {
		this.lastUpdated=new Date() ; 
	}
	
}
