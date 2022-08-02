package com.shoppingcart.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;
import com.shoppingcart.models.Product;

import com.shoppingcart.repositories.ProductRepository;

@Service
public class ProductService {

	
	private final ProductRepository productRepository;

	
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void createProduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(p -> products.add(p));
		return products;
	}

	public List<Product> getAllAvailableProducts() {
		return productRepository.findProductsByQuantityGreaterThan(0);
	}
	
	

}
