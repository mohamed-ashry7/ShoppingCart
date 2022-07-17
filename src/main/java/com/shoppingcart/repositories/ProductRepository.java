package com.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	
	public List<Product> findProductsByQuantityGreaterThan(int number) ; 
}
