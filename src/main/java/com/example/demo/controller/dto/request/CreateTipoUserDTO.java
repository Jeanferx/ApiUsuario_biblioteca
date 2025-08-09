package com.example.demo.controller.dto.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateTipoUserDTO {
	@NotEmpty
	@Size(max =50)
	private String tipousuario;
}
