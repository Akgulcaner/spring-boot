package com.caner.controller;

import com.caner.dto.DtoCustomer;

public interface  ICustomerController {
    public DtoCustomer findCustomerById(Long id);
}
