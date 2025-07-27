package com.example.demo.dao;

import com.example.demo.model.UserModel;

public interface UserDao {

	UserModel getUserById(String userId);
	
	UserModel createUser(UserModel user);
	
	UserModel updateUser (String userId, UserModel user);

}
