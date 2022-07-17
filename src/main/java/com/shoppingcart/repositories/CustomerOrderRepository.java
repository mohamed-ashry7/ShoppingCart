package com.shoppingcart.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.models.CustomerOrder;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Integer> {

}
