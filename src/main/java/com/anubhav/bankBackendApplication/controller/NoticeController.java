package com.anubhav.bankBackendApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @GetMapping("/notice")
    public String getBalanceDetails(){
        return "Here are all the notices";
    }
}
