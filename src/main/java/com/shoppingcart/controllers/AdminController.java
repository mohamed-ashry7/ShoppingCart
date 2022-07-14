package com.shoppingcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.models.Product;
import com.shoppingcart.services.ProductService;

@RestController
@RequestMapping(path="/admin",produces = "application/json")
@CrossOrigin(origins="*")
public class AdminController {

	
	@Autowired 
	private ProductService productService ; 
	
	@PostMapping("/addProduct")
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
	}
	
	
}
