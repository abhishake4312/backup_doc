package com.learn.springsecuritysection10.service;

import com.learn.springsecuritysection10.model.Customer;
import com.learn.springsecuritysection10.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomersService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customers){
        return customerRepository.save(customers);
    }
}
