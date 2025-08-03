package com.example.demo.dao.jpa.entity;

import java.util.Date;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * Esta clase mapea una tabla en base de datos llamada user
 * */
@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@UuidGenerator
	private String id;
	private String name;
	private Date dateOfBirth;
	private String email;
	private String passwd;
	
	public UserEntity() {}
	
	public UserEntity(String id, String name, Date dateOfBirth, String email, String passwd) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.passwd = passwd;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
