package com.anubhav.bankBackendApplication.controller;

import com.anubhav.bankBackendApplication.model.Customer;
import com.anubhav.bankBackendApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Customer customer){
        Customer savedCustomer=null;
        ResponseEntity response= null;
        try{
            String hashedpwd=passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedpwd);
            savedCustomer=customerRepository.save(customer);
            if(savedCustomer.getId()>0){
                response=ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are registered successfully");
            }
        }
        catch(Exception e){
            response=ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to "+ e.getMessage());
        }
        return response;

    }
}
