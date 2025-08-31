package com.example.demo.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.jpa.entity.UserEntity;
import com.example.demo.dao.jpa.repository.UserRepository;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserModel;

@ExtendWith(MockitoExtension.class)
public class UserDaoImplTest {
	private static final String USER_ID = "a3808979-e952-44bf-81a6-c31fbbc19572";
	private static final String USER_NAME = "userName";
	private static final String USER_EMAIL = "user@email.com";

	//la anotacion mock significa que vamos a "simular" las respuestas de los metodos del bean
	//en lugar de crear un bean repository va a crear una maqueta sin funcion real
	@Mock
	private UserRepository userRepository;
	
	//la clase que se va a probar
	private UserDao userDao;
	
	//Esta anotacion dice que se ejecutara 
	@BeforeEach
	//este metodo es para configurar el bean que vamos a probar
	void setUp() {
		//si la clase userDao tuviera mas parametros se tendrian que pasar en el constructor
		userDao = new UserDaoImpl(userRepository);
	}
	
	@Test
	void getUserById_test_success() {
		//con esto le indico al mock del userRepository que cuando se haga un llamado al metodo findById
		//con el dato USER_ID se devuelva el entity 
		when(userRepository.findById(USER_ID)).thenReturn(Optional.of(getUserEntity_forTests()));
		
		//ahora hago el llamado al metodo que quiero probar
		UserModel user = userDao.getUserById(USER_ID);
		
		//ahora vamos a validar que el usuario que nos regresa no sea nullo
		assertThat(user).isNotNull();
		//tambien vamos a validar que el id del usuario que nos regresa es el esperado
		assertThat(user.getId()).isEqualTo(USER_ID);
	}
	
	@Test
	void getUserById_test_userNotFound() {
		//Tambien le puedes decir al mock que te regrese algun valor sin importar el parametro de entrada
		when(userRepository.findById(anyString())).thenReturn(Optional.empty());
		
		//esto captura la excepcion que resulte de llamar al metodo, en teoria
		//deberia lanzarse una excepcion de tipo userNotFoundException
		// esto () -> metodo() es una llamada de funcion lambda, luego llegaremos a eso
		Throwable userException = catchThrowable(() -> userDao.getUserById(USER_ID));
		//aqui estoy probando que la excepcion recibida sea de tipo UserNotFoundException
		assertThat(userException).isInstanceOf(UserNotFoundException.class);
	}
	
	//este metodo solo es para devolver un userEntity como si el userRepository lo hubiera encontrado en bd
	private UserEntity getUserEntity_forTests() {
		UserEntity u = new UserEntity();
		u.setId(USER_ID);
		//TODO 
		//este metodo esta deprecado, cambiar el campo dateOfBirth de Date a Instant
		u.setDateOfBirth(new Date(01,01,1990));
		u.setName(USER_NAME);
		u.setEmail(USER_EMAIL);
		return u;
	}
}
