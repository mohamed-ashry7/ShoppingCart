package com.shoppingcart.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Entity
public @Data class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ; 
	
	private Date lastUpdated; 
	private String name ;
	
	@PrePersist
	@PreUpdate
	public void lastUpdated() {
		this.lastUpdated=new Date() ; 
	}
	
	
}
