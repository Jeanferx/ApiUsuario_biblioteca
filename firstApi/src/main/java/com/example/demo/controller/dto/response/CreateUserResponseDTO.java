package com.example.demo.controller.dto.response;

public class CreateUserResponseDTO {

	private String id;

	public CreateUserResponseDTO() {}
	
	public CreateUserResponseDTO(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
