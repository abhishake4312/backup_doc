package com.learn.springsecuritysection3.controller;

import com.learn.springsecuritysection3.model.Customers;
import com.learn.springsecuritysection3.service.RegisterCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterCustomersController {

    @Autowired
    RegisterCustomersService registerCustomersService;

    @PostMapping("/register")
    public ResponseEntity<Customers> registerCustomer(@RequestBody Customers customers){
        Customers savedCustomer=null;
        ResponseEntity responseEntity=null;
        try {
            savedCustomer = registerCustomersService.saveCustomer(customers);
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
