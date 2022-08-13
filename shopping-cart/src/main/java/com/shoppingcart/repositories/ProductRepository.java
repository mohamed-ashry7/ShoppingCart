package com.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shoppingcart.models.Product;


@CrossOrigin("*")
public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	
	public List<Product> findProductsByQuantityGreaterThan(int number) ; 
}
