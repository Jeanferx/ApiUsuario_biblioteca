package com.example.demo.exception;

//esta excepcion es especifica para cuando no encuentre un usuario
public class UserNotFoundException extends UserException{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}
}
