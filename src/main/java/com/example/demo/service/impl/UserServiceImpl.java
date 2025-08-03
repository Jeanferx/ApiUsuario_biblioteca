package com.example.demo.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.jpa.entity.UserEntity;
import com.example.demo.dao.jpa.repository.UserRepository;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

//esta anotacion le dice a esta clase que es un bean de spring
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
		super();
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	//esta anotacion le dice que va a implementar el metodo de la interfaz o una clase padre
	//esta anotacion no es obligatoria pero es buenas practicas
	@Override
	@Transactional
	public UserModel getUserById(String userId) {
		UserModel userModel = new UserModel();
		System.out.println("logica transladada al service");
		System.out.println("Peticion de obtener el user con id " + userId);
		
		return userDao.getUserById(userId);
	}

	@Override
	@Transactional
	public UserModel createUser(UserModel user) {
		System.out.println("Creando un usuario nuevo");
		
		System.out.println("Agregamos un poco de logica, vamos a hashear la contrasena");
		String hashedPass = passwordEncoder.encode(user.getPasswd());
		user.setPasswd(hashedPass);
		
		return userDao.createUser(user);
	}
	@Override
	@Transactional
	public UserModel updateUser(String userId, UserModel user) {
	    System.out.println("Actualizando usuario con ID: " + userId);
	    if (user.getPasswd() != null && !user.getPasswd().isEmpty()) {
	        System.out.println("Hasheando nueva contraseña");
	        String hashedPass = passwordEncoder.encode(user.getPasswd());
	        user.setPasswd(hashedPass);
	    }
	    return userDao.updateUser(userId, user);
	}
	@Override
	@Transactional
	public UserModel deleteUser(String userId) {
		UserModel userModel = new UserModel();
	    System.out.println("Eliminando usuario con ID: " + userId);
	    return userDao.deleteUser(userId);
	}


}
