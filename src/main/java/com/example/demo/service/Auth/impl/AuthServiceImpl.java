package com.example.demo.service.Auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dto.request.LoginRequest;
import com.example.demo.controller.dto.response.LoginResponse;
import com.example.demo.dao.jpa.entity.UserEntity;
import com.example.demo.dao.jpa.repository.UserRepository;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.service.Auth.AuthService;
import com.example.demo.service.token.JwtService;
@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private  UserRepository userRepository;
	@Autowired
    private  JwtService jwtService;
	@Autowired
    private  PasswordEncoder passwordEncoder;
	@Override
    public LoginResponse login(LoginRequest request) {
        // Buscar usuario por email
		UserEntity user = userRepository.findByEmail(request.getEmail())
		        .orElseThrow(() -> new InvalidCredentialsException("Usuario no encontrado"));

		if (!passwordEncoder.matches(request.getPasswd(), user.getPasswd())) {  // <- usa getPasswd()
		    throw new InvalidCredentialsException("Contraseña incorrecta");
		}

		String token = jwtService.generateToken(user);
		return new LoginResponse(token, "Login exitoso");

    }
	

}
