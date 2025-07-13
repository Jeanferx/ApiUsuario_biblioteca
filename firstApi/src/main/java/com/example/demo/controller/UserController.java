package com.example.demo.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;

@RestController
@RequestMapping
public class UserController {

	@GetMapping("/users/{userId}")
	public UserModel getUserById(@PathVariable("userId") String userId) {
		UserModel userModel = new UserModel();
		System.out.println("Peticion de obtener el user con id " + userId);
		
		userModel.setId(userId);
		userModel.setName("Jean");
		userModel.setDateOfBirth(new Date());
		return userModel;
	}

	@PostMapping("/users")
	public UserModel createUser(@RequestBody UserModel user) {
		System.out.println("Creando un usuario nuevo");
		user.setId(UUID.randomUUID().toString());
		return user;
	}
}
