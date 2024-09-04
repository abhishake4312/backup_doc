package com.learn.springsecuritysection3.config;


import com.learn.springsecuritysection3.model.Authority;
import com.learn.springsecuritysection3.model.Customer;
import com.learn.springsecuritysection3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String rawPassword = authentication.getCredentials().toString();
        List<Customer> customersList=customerRepository.findByEmail(username);
        if(customersList.size()>0){
            if(passwordEncoder.matches(rawPassword,customersList.get(0).getPwd())){
               List<GrantedAuthority> authorities=getGrantedAuthorities(customersList.get(0).getAuthorities());
               return new UsernamePasswordAuthenticationToken(username,rawPassword,authorities);
            }else{
                throw new BadCredentialsException("Bad credentials");
            }
        }else{
            throw new BadCredentialsException("No user exists");
        }
    }
    public List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authoritySet) {
        List<GrantedAuthority> authorities=new ArrayList<>();
        for(Authority authority:authoritySet){
            authorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return authorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
