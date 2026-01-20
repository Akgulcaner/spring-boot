package com.caner.services;



import org.springframework.stereotype.Service;

import com.caner.dto.DtoHome;

@Service
public interface IHomeService {
    public DtoHome findHomeById(Long id);
}
