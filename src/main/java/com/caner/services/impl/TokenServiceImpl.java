package com.caner.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.caner.dto.TokenContentResponse;
import com.caner.services.ITokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenServiceImpl implements ITokenService{

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Override
    public TokenContentResponse getTokenContent(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();

        TokenContentResponse response = new TokenContentResponse();
        response.setClaims(claims);


        return response;
    }
}
