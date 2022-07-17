package com.shoppingcart.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.models.Cart;
import com.shoppingcart.models.CartItem;
import com.shoppingcart.models.Customer;
import com.shoppingcart.models.CustomerOrder;
import com.shoppingcart.models.EmailSubscriber;
import com.shoppingcart.services.CartService;
import com.shoppingcart.services.CustomerOrderService;
import com.shoppingcart.services.CustomerService;
import com.shoppingcart.services.EmailSubscriberService;

@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin(origins="*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartService cartService;


	@Autowired
	private EmailSubscriberService emailSubscriberService;
	

	@Autowired
	private CustomerOrderService customerOrderService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/customers/{customerId}/addCartItem")
	public Cart addCartItemToCart(@PathVariable int customerId, @RequestBody CartItem ci) {
		Customer c = this.customerService.getCustomerById(customerId);
		Cart cart = c.getCart();
		return this.cartService.addCartItem(cart.getId(), ci);
	}

	@PatchMapping("/customers/{customerId}/updateCartItemQuantity")
	public Cart updateCartItemToCart(@PathVariable int customerId, @RequestParam int quantity,
			@RequestParam int productId) {
		Customer c = this.customerService.getCustomerById(customerId);
		Cart cart = c.getCart();
		return this.cartService.updateCartItemQuantity(cart.getId(), productId, quantity);
	}
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@DeleteMapping("/customers/{customerId}/removeCartItem/{cartItemId}")
	public void deleteProduct(@PathVariable int customerId, @PathVariable int cartItemId) {
		Customer c = this.customerService.getCustomerById(customerId);
		Cart cart = c.getCart();
		this.cartService.removeCartItemFromCart(cart.getId(), cartItemId);

	}
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@DeleteMapping("/customers/{customerId}/emptyCart")
	public void emptyCart(@PathVariable int customerId) {
		Customer c = this.customerService.getCustomerById(customerId);
		Cart cart = c.getCart();
		this.cartService.emptyTheCart(cart.getId());
	}
	
	@PostMapping("/customers/{customerId}/subscribe")
	public void createEmailSubscriber(@PathVariable int customerId) {
		Customer c = customerService.getCustomerById(customerId);
		EmailSubscriber es = new EmailSubscriber(); 
		es.setFirstName(c.getFirstName());
		es.setLastName(c.getLastName());
		es.setEmail(c.getEmail());
		emailSubscriberService.createEmailSubscriber(es); 
	}
	
	@PostMapping("/customers/{customerId}/placeOrder")
	public void placeOrder(@PathVariable int customerId) {
		Customer c = this.customerService.getCustomerById(customerId);
		Cart cart = c.getCart(); 
		CustomerOrder co = new CustomerOrder(); 
		co.setCartItems(cart.getCartItems()) ; 
		co.setTotalPrice(cart.getCartTotal()); 
		co.setCustomer(c);
		co.setStatus("Placed");
		this.customerOrderService.createCustomerOrder(co);
	}

}
