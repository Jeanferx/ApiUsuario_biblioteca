package com.example.demo.controller.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class LoginResponse {
	
	private String token;
    private String message;
}
