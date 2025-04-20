package com.erick.company.controller;

import com.erick.company.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final TokenService tokenService;

    @PostMapping("/token")
    public String token(Authentication auth) {
        log.info("Token Requested for user: '{}'", auth.getName());
        String token = tokenService.generateToken(auth);
        log.info("Token granted {}", token);
        return token;
    }
}
