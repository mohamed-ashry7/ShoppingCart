package com.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	
	
	public List<Product> findProductsByQuantityGreaterThan(int number) ; 
}
