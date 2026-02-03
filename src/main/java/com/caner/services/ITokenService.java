package com.caner.services;

import org.springframework.stereotype.Service;

import com.caner.dto.TokenContentResponse;

@Service
public interface ITokenService {
    TokenContentResponse getTokenContent(String token);
}
