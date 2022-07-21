package com.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.models.EmailSubscriber;

public interface EmailSubscriberRepository extends JpaRepository<EmailSubscriber,Integer>{

}
