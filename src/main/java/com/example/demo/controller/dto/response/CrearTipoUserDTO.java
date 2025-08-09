package com.example.demo.controller.dto.response;

public class CrearTipoUserDTO {
	private String id;

	public CrearTipoUserDTO() {}
	
	public CrearTipoUserDTO(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
