package com.shoppingcart.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
public @Data class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int quantity;
	private double total;

	@OneToOne
	private Product product;

	public double getTotal() {
		total = this.product.getPrice()*this.quantity;
		return total ; 
	}


}
