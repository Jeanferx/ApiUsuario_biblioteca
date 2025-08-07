package com.example.demo.service;

import com.example.demo.model.UserModel;
import java.util.List;

//Aqui defino la interfaz de userService, con las definiciones de los metodos
public interface UserService {

	UserModel getUserById(String userId);
	
	UserModel createUser(UserModel user);
	
	UserModel updateUser(String userId, UserModel user);
	
	UserModel deleteUser(String userId);

	List<UserModel> getAllUsers(); // antes: UserModel getAllUsers();

}
