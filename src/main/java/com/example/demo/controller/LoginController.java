package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.request.LoginRequest;
import com.example.demo.controller.dto.response.LoginResponse;
import com.example.demo.service.Auth.AuthService;

import jakarta.validation.Valid;

@RestController
public class LoginController {

    private final AuthService authService;

    // Inyección por constructor (más recomendable que @Autowired en campo)
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
