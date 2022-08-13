package com.shoppingcart.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shoppingcart.models.Cart;

@CrossOrigin("*")
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
