package com.shoppingcart.repositories;


import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
