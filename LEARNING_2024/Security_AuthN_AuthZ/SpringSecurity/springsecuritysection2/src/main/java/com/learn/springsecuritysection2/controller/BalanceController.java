package com.learn.springsecuritysection2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/myBalances")
    public String getBalance(){
        return "Here are the balance details from the DB";
    }
}
