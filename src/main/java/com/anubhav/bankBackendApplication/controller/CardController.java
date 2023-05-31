package com.anubhav.bankBackendApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @GetMapping("/myCards")
    public String getBalanceDetails(){
        return "Here are your card details";
    }
}
