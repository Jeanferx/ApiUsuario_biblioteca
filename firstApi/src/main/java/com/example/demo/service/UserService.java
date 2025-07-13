package com.example.demo.service;

import com.example.demo.model.UserModel;

//Aqui defino la interfaz de userService, con las definiciones de los metodos
public interface UserService {

	UserModel getUserById(String userId);
	
	UserModel createUser(UserModel user);
}
