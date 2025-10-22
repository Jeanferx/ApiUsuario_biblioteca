package com.example.demo.controller.dto.request;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class LoginRequest {
	@NotEmpty
	@Size(max = 50)
	private String email;
	@NotEmpty
	@Size(max = 20)
	private String passwd;
}
