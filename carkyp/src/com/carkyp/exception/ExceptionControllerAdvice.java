package com.carkyp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.mongodb.MongoException;


 
 
@ControllerAdvice
public class ExceptionControllerAdvice {
	
	private final static int DUPLICATE_ERROR_CODE = 402;
	private final static String DUPPLICATE_ERROR_MESSAGE = "Service Provider with those email address allredy exist.";
 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("Please contact your administrator");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(org.springframework.data.mongodb.core.MongoDataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> DupExceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(DUPLICATE_ERROR_CODE);
		error.setMessage(DUPPLICATE_ERROR_MESSAGE);
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
	
}