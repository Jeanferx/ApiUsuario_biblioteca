package com.example.demo.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.jpa.entity.UserEntity;
import com.example.demo.dao.jpa.repository.UserRepository;
import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserModel;
import java.util.List;
import java.util.ArrayList;
@Service
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserModel getUserById(String userId) {
		Optional<UserEntity> e = repository.findById(userId);
		UserModel model = new UserModel();
		
		if (e.isPresent()) {
			model.setId(e.get().getId());
			model.setDateOfBirth(e.get().getDateOfBirth());
			model.setName(e.get().getName());
			model.setEmail(e.get().getEmail());
			model.setPasswd(e.get().getPasswd());
		}else {
			//Si no hay user entonces que lance una excepcion controlada de tipo UserNotFoundException
			String errorMsg = "The user with id %s was not found";
			throw new UserNotFoundException(String.format(errorMsg, userId));
		}
		return model;
	}
	@Override
	public UserModel updateUser(String userId, UserModel user) {
	    Optional<UserEntity> existingUser = repository.findById(userId);
	    if (existingUser.isPresent()) {
	        UserEntity userEntity = existingUser.get();
	        userEntity.setName(user.getName());
	        userEntity.setDateOfBirth(user.getDateOfBirth());
	        userEntity.setEmail(user.getEmail());
	        userEntity.setPasswd(user.getPasswd());
	        repository.save(userEntity);

	        user.setId(userId);
	        return user;
	    } else {
	        throw new RuntimeException("Usuario no encontrado con ID: " + userId);
	    }
	}
	@Override
	public List<UserModel> getAllUsers() {
        List<UserEntity> entities = repository.findAll();
        List<UserModel> models = new ArrayList<>();

        for (UserEntity e : entities) {
            UserModel model = new UserModel();
            model.setId(e.getId());
            model.setDateOfBirth(e.getDateOfBirth());
            model.setName(e.getName());
            model.setEmail(e.getEmail());
            model.setPasswd(e.getPasswd());
            models.add(model);
        }
        return models;
    }

	@Override
	public UserModel deleteUser(String userId) {
		UserModel model = new UserModel();
	    Optional<UserEntity> existingUser = repository.findById(userId);
	    if (existingUser.isPresent()) {
	        UserEntity userEntity = existingUser.get();

	        UserModel userModel = new UserModel();
	        userModel.setId(userEntity.getId());
	        userModel.setName(userEntity.getName());
	        userModel.setDateOfBirth(userEntity.getDateOfBirth());

	        repository.deleteById(userId);

	        return userModel;
	    }
	    return null;
	}





	@Override
	public UserModel createUser(UserModel user) {
	    // 1️⃣ Verificar si el correo ya existe
	    Optional<UserEntity> existingUser = repository.findByEmail(user.getEmail());
	    if (existingUser.isPresent()) {
	        throw new EmailAlreadyExistsException(
	            "El correo " + user.getEmail() + " ya está registrado"
	        );
	    }

	    // 2️⃣ Crear y guardar el usuario
	    UserEntity userEntity = new UserEntity();
	    userEntity.setDateOfBirth(user.getDateOfBirth());
	    userEntity.setName(user.getName());
	    userEntity.setEmail(user.getEmail());
	    userEntity.setPasswd(user.getPasswd());

	    userEntity = repository.save(userEntity);
	    user.setId(userEntity.getId());

	    return user;
	}


	public UserDaoImpl(UserRepository repository) {
		this.repository = repository;
	}

	public UserRepository getUserRepository() {
		return repository;
	}

	public void setUserRepository(UserRepository repository) {
		this.repository = repository;
	}
}
