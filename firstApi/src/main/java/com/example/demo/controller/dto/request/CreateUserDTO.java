package com.example.demo.controller.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class CreateUserDTO {

	@NotEmpty
	@Size(max =50)
	private String name;
	
	@NotNull
	@Past
	private Date dateOfBirth;
	
	@NotEmpty
	@Size(max = 50)
	private String email;
	
	@NotEmpty
	@Size(max = 20)
	private String passwd;
	
	public CreateUserDTO(){}
	
	public CreateUserDTO(String name, Date dateOfBirth, String email, String passwd) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.passwd = passwd;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
