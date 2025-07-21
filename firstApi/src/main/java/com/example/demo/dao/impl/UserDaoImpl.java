package com.example.demo.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.jpa.entity.UserEntity;
import com.example.demo.dao.jpa.repository.UserRepository;
import com.example.demo.model.UserModel;

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
		}
		return model;
	}

	@Override
	public UserModel createUser(UserModel user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setDateOfBirth(user.getDateOfBirth());
		userEntity.setName(user.getName());
		
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
