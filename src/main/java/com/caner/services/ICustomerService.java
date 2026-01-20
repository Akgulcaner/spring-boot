package com.caner.services;

import org.springframework.stereotype.Service;

import com.caner.dto.DtoCustomer;

@Service
public interface  ICustomerService {
    public DtoCustomer findCustomerById(Long id);
}
