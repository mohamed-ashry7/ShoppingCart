package com.shoppingcart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.models.Product;
import com.shoppingcart.services.ProductService;

@RestController
@CrossOrigin("*")
public class HomeController {

	private final ProductService productService ; 
	
	
	
	public HomeController(ProductService productService) {
		this.productService = productService;
	}



	@GetMapping("/")
	public ResponseEntity<?>  home() {
		Map<String,List<Product>> res = new HashMap<>();
		res.put("products", productService.getAllAvailableProducts());
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
}
