package com.learn.springsecuritysection10.controller;

import com.learn.springsecuritysection10.model.Customer;
import com.learn.springsecuritysection10.service.RegisterCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterCustomersController {

    @Autowired
    RegisterCustomersService registerCustomersService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
        Customer savedCustomer=null;
        ResponseEntity responseEntity=null;
        try {
            String hashPassword=passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPassword);
            savedCustomer = registerCustomersService.saveCustomer(customer);
            if (savedCustomer.getId() > 0) {
                responseEntity = ResponseEntity.status(HttpStatus.CREATED).body("Given customer registered Successfully");
            }
        }
            catch(Exception ex){
                responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("an exception occurred due to "+ex.getMessage());
            }
        return responseEntity;

    }
}
