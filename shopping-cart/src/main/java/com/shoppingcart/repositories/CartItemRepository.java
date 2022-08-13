package com.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shoppingcart.models.CartItem;

@CrossOrigin("*")
public interface CartItemRepository  extends JpaRepository<CartItem,Integer>{

}
