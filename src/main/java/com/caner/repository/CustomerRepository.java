package com.caner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caner.entities.Customer;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer, Long>{
    
}
