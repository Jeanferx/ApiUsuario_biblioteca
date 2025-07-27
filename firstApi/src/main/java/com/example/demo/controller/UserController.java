package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	//Esta anotacion se llama autowired y es para indicarle a spring que va a inyectar un bean 
	//de tipo UserService
	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
	public UserModel getUserById(@PathVariable("userId") String userId) {
		return userService.getUserById(userId);
	}

	@PostMapping("/users")
	public UserModel createUser(@RequestBody UserModel user) {
		return userService.createUser(user);
	}
	@PutMapping("/{userId}")
	public UserModel updateUser(@PathVariable("userId") String userId, @RequestBody UserModel user) {
        return userService.updateUser(userId, user);
    }
	@DeleteMapping("/{userId}")
	public UserModel deleteUser(@PathVariable("userId") String userId) {
	    return userService.deleteUser(userId);
	}



	//GETTERS Y SETTERS
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
