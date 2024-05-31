package com.example.GlobalExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.CustomExce.IdNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<String> IdNotFoundHandler(IdNotFound idNotFound){
		return new ResponseEntity<String>(idNotFound.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
