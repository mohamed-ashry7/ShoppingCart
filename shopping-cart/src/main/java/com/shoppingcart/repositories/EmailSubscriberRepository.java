package com.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shoppingcart.models.EmailSubscriber;


@CrossOrigin("*")
public interface EmailSubscriberRepository extends JpaRepository<EmailSubscriber,Integer>{

}
