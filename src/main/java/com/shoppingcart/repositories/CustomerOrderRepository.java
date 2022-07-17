package com.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.models.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

}
