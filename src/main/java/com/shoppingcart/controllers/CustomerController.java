package com.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.shoppingcart.services.CartService;
import com.shoppingcart.services.CustomerService;

@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin(origins="*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartService cartService;

	@PostMapping("/signup")
	public void createCustomer(@RequestBody Customer c) {
		this.customerService.createCustomer(c);
	}

	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addProduct/{customerId}")
	public Cart addProductToCart(@PathVariable int customerId, @RequestBody CartItem ci) {
		Customer c = this.customerService.getCustomerById(customerId);
		Cart cart = c.getCart();
		return this.cartService.addCartItem(cart.getId(), ci);
	}

	@PatchMapping("/updateProductQuantity/{customerId}")
	public Cart addProductToCart(@PathVariable int customerId, @RequestParam int quantity,
			@RequestParam int productId) {
		Customer c = this.customerService.getCustomerById(customerId);
		Cart cart = c.getCart();
		return this.cartService.updateProductQuantity(cart.getId(), productId, quantity);
	}
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@DeleteMapping("/removeProduct/{customerId}")
	public void deleteProduct(@PathVariable int customerId, @RequestParam int productId) {
		Customer c = this.customerService.getCustomerById(customerId);
		Cart cart = c.getCart();
		this.cartService.removeProductFromCart(cart.getId(), productId);

	}
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@DeleteMapping("/emptyCart/{customerId}")
	public void emptyCart(@PathVariable int customerId) {
		Customer c = this.customerService.getCustomerById(customerId);
		Cart cart = c.getCart();
		this.cartService.emptyTheCart(cart.getId());
	}

}
