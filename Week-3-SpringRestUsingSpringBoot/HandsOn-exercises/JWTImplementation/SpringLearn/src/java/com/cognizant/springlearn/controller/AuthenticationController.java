package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    public AuthenticationController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        String username = extractUsername(authHeader);

        String token = jwtService.generateToken(username);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }

    private String extractUsername(String authHeader) {

        String encodedCredentials = authHeader.substring(6).trim();

        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);

        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        return credentials.split(":")[0];
    }
}