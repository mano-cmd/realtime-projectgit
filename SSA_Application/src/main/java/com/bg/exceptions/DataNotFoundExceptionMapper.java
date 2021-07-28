package com.bg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController; 

@RestController
@ControllerAdvice
public class DataNotFoundExceptionMapper {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorResponse> response(){
		ErrorResponse body=new ErrorResponse();
		
		body.setErrorCode("HSP001");
		body.setErrorDesc("Invalid SSN Number Please Enter Valid SSN Number");
		
		ResponseEntity<ErrorResponse> entity=new ResponseEntity<ErrorResponse>(body, HttpStatus.BAD_REQUEST);
		return entity;
	}
}
