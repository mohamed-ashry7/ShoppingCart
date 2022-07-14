package com.shoppingcart.services;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shoppingcart.models.Cart;
import com.shoppingcart.models.CartItem;
import com.shoppingcart.models.Product;


@SpringBootTest
public class CartServiceTests {

	
	@Autowired
	private CartService cartService ; 
	
	@Autowired
	private ProductService productService; 
	
	
	@Test
	void addingCartItem() { 
		Cart t = new Cart();
		cartService.createCart(t);
		int id = t.getId();
		CartItem ci = new CartItem(); 
		cartService.addCartItem(id, ci);
		assert cartService.getCartById(id).getNumberOfItems()==1;
	}
	
	@Test
	void updatingProductQuantity() {
		Cart t = new Cart(); 
		cartService.createCart(t);
		int id = t.getId();
		CartItem ci = new CartItem(); 
		Product p = new Product() ; 
		productService.createProduct(p);
		ci.setProduct(p);
		
		cartService.addCartItem(id, ci);
		assert cartService.getProductQuantityInCart(id, p.getId())==0;
		
		
		this.cartService.updateProductQuantity(t.getId(), p.getId(), 3);
		assert cartService.getProductQuantityInCart(id, p.getId())==3;


	}
	
	@Test
	void deletingProductFromCart() {
		Cart t = new Cart(); 
		cartService.createCart(t);
		int cartId = t.getId();
		CartItem ci = new CartItem(); 
		Product p = new Product() ; 
		productService.createProduct(p);
		ci.setProduct(p);
		cartService.addCartItem(cartId, ci);
		
		assert this.cartService.getNumberOfItemsInCart(cartId) == 1 ; 
		
		this.cartService.removeProductFromCart(cartId,p.getId()) ; 
		assert this.cartService.getNumberOfItemsInCart(cartId) == 0 ; 

		
		
	}
	
	@Test
	void emptyingTheCart() {
		Cart t = new Cart(); 
		cartService.createCart(t);
		int cartId = t.getId();
		CartItem ci = new CartItem(); 
		Product p = new Product() ; 
		productService.createProduct(p);
		ci.setProduct(p);
		
		CartItem ci2 = new CartItem(); 
		Product p2 = new Product() ; 
		productService.createProduct(p2);
		ci2.setProduct(p2);
		
		cartService.addCartItem(cartId, ci);
		cartService.addCartItem(cartId, ci2);

		
		
		assert this.cartService.getNumberOfItemsInCart(cartId) == 2 ; 
		
		this.cartService.emptyTheCart(cartId); 
		assert this.cartService.getNumberOfItemsInCart(cartId) == 0 ; 

		
		
	}
}
