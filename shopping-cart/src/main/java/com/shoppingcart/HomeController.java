package com.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.models.Product;
import com.shoppingcart.services.ProductService;

@RestController
public class HomeController {

	@Autowired
	private ProductService productService ; 
	
	@GetMapping("/")
	public List<Product> home() {
		return productService.getAllAvailableProducts(); 
	}
}
