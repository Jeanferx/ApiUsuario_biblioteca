package com.example.demo.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

//esta anotacion le dice a esta clase que es un bean de spring
@Service
public class UserServiceImpl implements UserService{

	//esta anotacion le dice que va a implementar el metodo de la interfaz o una clase padre
	//esta anotacion no es obligatoria pero es buenas practicas
	@Override
	public UserModel getUserById(String userId) {
		UserModel userModel = new UserModel();
		System.out.println("logica transladada al service");
		System.out.println("Peticion de obtener el user con id " + userId);
		
		userModel.setId(userId);
		userModel.setName("Jean");
		userModel.setDateOfBirth(new Date());
		return userModel;
	}

	@Override
	public UserModel createUser(UserModel user) {
		System.out.println("Creando un usuario nuevo");
		user.setId(UUID.randomUUID().toString());
		return user;
	}

}
