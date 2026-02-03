package com.caner.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caner.dto.TokenContentResponse;
import com.caner.services.ITokenService;

@RestController
@RequestMapping("/api/token")
public class TokenController {
    @Autowired
    private ITokenService tokenService;

    @PostMapping("/decode")
    public TokenContentResponse decodeToken(@RequestParam String token) {
        return tokenService.getTokenContent(token);
    }
}
