package com.anubhav.bankBackendApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/myLoans")
    public String getBalanceDetails(){
        return "Here are your loan details";
    }
}
