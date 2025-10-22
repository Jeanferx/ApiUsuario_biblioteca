package com.example.demo.controller.advice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.exception.UserNotFoundException;

@RestControllerAdvice
public class RestControllerAdviceImpl {

	/*Esto mapea el error del bad request de las validaciones de los argumentos*/
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex) {
  		System.out.println(ex.toString());
		ErrorMessage errorMessage  = new ErrorMessage();		
		List<String> errorList = ex.getFieldErrors().stream().map(fe -> {
			String field = fe.getField()+", "+fe .getDefaultMessage();
			return field;
		}).toList();
		errorMessage.setMessages(errorList);
		return errorMessage;
	}
	
	/*Esto mapea el error userNotFound
	 * Y por tanto va a regresar un codigo http 404 not found*/
	@ExceptionHandler({UserNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleUserNotFound(
			UserNotFoundException ex) {
  		System.out.println(ex.toString());
		ErrorMessage errorMessage  = new ErrorMessage();		
		List<String> errorList = List.of(ex.getMessage());
		errorMessage.setMessages(errorList);
		return errorMessage;
	}
	@ExceptionHandler({EmailAlreadyExistsException.class})
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorMessage handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
	    return new ErrorMessage(List.of(ex.getMessage()));
	}
	@ExceptionHandler({InvalidCredentialsException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorMessage handleInvalidCredentials(InvalidCredentialsException ex) {
	    return new ErrorMessage(List.of(ex.getMessage()));
	}

}
