package com.shoppingcart.repositories;


import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.models.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer>{

}
