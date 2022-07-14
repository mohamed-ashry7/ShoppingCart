package com.shoppingcart.services;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shoppingcart.models.Product;


@SpringBootTest
public class ProductServiceTests {

	
	@Autowired
	ProductService productService ; 
	
	@Test
	void createProductTest() {
		int size  = productService.getAllProducts().size(); 
		Product p = new Product() ; 
		p.setDescription("Just a test");
		productService.createProduct(p);
		List<Product> allProducts = productService.getAllProducts();
		int newSize = allProducts.size(); 
		assert size+1==newSize ; 
		assert allProducts.get(newSize-1).getDescription().equals("Just a test");
	}
}
