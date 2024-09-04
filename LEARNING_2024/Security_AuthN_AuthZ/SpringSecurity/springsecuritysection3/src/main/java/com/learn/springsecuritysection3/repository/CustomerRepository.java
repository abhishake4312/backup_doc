package com.learn.springsecuritysection3.repository;


import com.learn.springsecuritysection3.model.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customers,Long> {

    List<Customers> findByEmail(String email);
}
