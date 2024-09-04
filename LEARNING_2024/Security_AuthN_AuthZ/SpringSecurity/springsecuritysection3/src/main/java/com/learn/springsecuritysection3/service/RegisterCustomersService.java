package com.learn.springsecuritysection3.service;

import com.learn.springsecuritysection3.model.Customers;
import com.learn.springsecuritysection3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomersService {

    @Autowired
    CustomerRepository customerRepository;

    public Customers saveCustomer(Customers customers){
        return customerRepository.save(customers);
    }
}
