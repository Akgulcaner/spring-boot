package com.caner.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caner.dto.DtoAddress;
import com.caner.dto.DtoCustomer;
import com.caner.entities.Address;
import com.caner.entities.Customer;
import com.caner.repository.CustomerRepository;
import com.caner.services.ICustomerService;


@Service
public class CustomerServiceImpl implements ICustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public DtoCustomer findCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Customer> optional= customerRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        Customer customer = optional.get();
        Address address = optional.get().getAddress();

        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(address, dtoAddress);
        dtoCustomer.setAddress(dtoAddress);
        return dtoCustomer;
    }
    
}
