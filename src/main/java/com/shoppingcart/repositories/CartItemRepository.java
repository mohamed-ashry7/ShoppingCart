package com.shoppingcart.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.models.CartItem;

public interface CartItemRepository  extends CrudRepository<CartItem,Integer>{

}
