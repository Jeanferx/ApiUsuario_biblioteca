package com.example.demo.exception;

/*
 * Esta es nuestra excepcion personalizada donde las demas excepciones van a heredar, y esta debe heredar de runtime exception
 * */
public class UserException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserException() {
		super();
	}

	public UserException(String message) {
		super(message);
	}
}
