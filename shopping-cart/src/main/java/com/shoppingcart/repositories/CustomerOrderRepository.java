package com.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shoppingcart.models.CustomerOrder;

@CrossOrigin("*")
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

}
