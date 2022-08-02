package com.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.models.CartItem;


public interface CartItemRepository  extends JpaRepository<CartItem,Integer>{

}
