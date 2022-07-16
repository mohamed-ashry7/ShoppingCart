package com.shoppingcart.services;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.models.Cart;
import com.shoppingcart.models.CartItem;
import com.shoppingcart.repositories.CartItemRepository;
import com.shoppingcart.repositories.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository ; 
	
	
	
	public void createCartItem(CartItem ci) { 
		cartItemRepository.save(ci) ; 
	}
	
	public CartItem getCartItembyId(int cartItemId) {
		return this.cartItemRepository.findById(cartItemId).get();
	}
	
	public Cart addCartItem(int cartId, CartItem cartItem) {
		Cart c = this.cartRepository.findById(cartId).get();
		this.cartItemRepository.save(cartItem);
		c.addCartItem(cartItem);
		return cartRepository.save(c);

	}

	public void createCart(Cart cart) {
		this.cartRepository.save(cart);
	}

	public int getNumberOfItemsInCart(int cartId) {
		return this.cartRepository.findById(cartId).get().getNumberOfItems();

	}

	public Cart getCartById(int cartId) {
		return this.cartRepository.findById(cartId).get();
	}

	public Cart updateCartItemQuantity(int cartId, int cartItemId, int newQuantity) {
		Cart c = this.getCartById(cartId);
		List<CartItem> cis = c.getCartItems();
		for (CartItem ci : cis) {
			if (ci.getId() == cartItemId) {
				if (ci.getProduct().getQuantity()<newQuantity) {
					break ; 
				}
				ci.setQuantity(newQuantity);
				this.cartItemRepository.save(ci);
				this.cartRepository.save(c);
				break ; 
			}
		}
		return c ; 
	}

	public int getCartItemQuantityInCart(int cartId, int cartItemId) {
		List<CartItem> cis = this.cartRepository.findById(cartId).get().getCartItems();
		for (CartItem ci : cis) {
			if (ci.getId() == cartItemId) {
				return ci.getQuantity();
			}
		}
		return -1 ; 
	}
	public void removeCartItemFromCart(int cartId, int cartItemId) { 
		Cart c = this.getCartById(cartId); 
		List<CartItem> cis = c.getCartItems().stream().filter(ci->ci.getId()!=cartItemId).collect(Collectors.toList());
		this.cartItemRepository.deleteById(cartItemId);
		c.setCartItems(cis);
		this.cartRepository.save(c);
	}
	
	public void emptyTheCart(int cartId) {
		Cart c = this.getCartById(cartId);
		c.getCartItems().clear();
		this.cartRepository.save(c);
	}
}
