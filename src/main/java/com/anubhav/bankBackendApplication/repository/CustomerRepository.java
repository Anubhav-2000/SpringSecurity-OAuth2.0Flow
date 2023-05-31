package com.anubhav.bankBackendApplication.repository;

import com.anubhav.bankBackendApplication.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByEmail(String email);

}
