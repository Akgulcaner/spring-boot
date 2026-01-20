package com.caner.controller;

import com.caner.dto.DtoHome;


public interface IHomeController {
    public DtoHome findHomeById(Long id);
}
