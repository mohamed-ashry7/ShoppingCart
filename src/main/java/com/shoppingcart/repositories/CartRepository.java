package com.shoppingcart.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
