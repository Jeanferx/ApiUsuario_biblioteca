package com.example.demo.service.Auth;

import com.example.demo.controller.dto.request.LoginRequest;
import com.example.demo.controller.dto.response.LoginResponse;

public interface AuthService {
	LoginResponse login(LoginRequest request);
}
