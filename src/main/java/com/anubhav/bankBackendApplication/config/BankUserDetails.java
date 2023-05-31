package com.anubhav.bankBackendApplication.config;

import com.anubhav.bankBackendApplication.model.Customer;
import com.anubhav.bankBackendApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankUserDetails implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String passwd=null;
        List<Customer> users= customerRepository.findByEmail(username);
        List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
        if(users.size()==0){
            throw new UsernameNotFoundException("User deatails not found");
        }
        else{
            passwd=users.get(0).getPwd();
            grantedAuthorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));

        }
        return new User(username,passwd,grantedAuthorities);
    }
}
