package com.shoppingcart.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Cart {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@OneToMany(targetEntity = CartItem.class,fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<CartItem> cartItems= new ArrayList<>();
	
	private double cartTotal;
 
	
	
	public int getNumberOfItems() {
		return this.cartItems.size();
	}
	public void addCartItem(CartItem c ) {
		this.cartItems.add(c); 
	}
	public void updateCartItem() {
		//TODO
	}
	public void removeCartItem() {
		//TODO
	}
	public void clearCart() {
		this.cartItems.clear();
	}
	public void calCartTotal() {
		double total = 0 ;
		for (CartItem c:cartItems) {
			total+=c.getTotal(); 
		}
		this.cartTotal=total; 
	}
	
}
