package com.diksha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.diksha.response.ResponseHandler;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex) {
		return ResponseHandler.generateResponse("Failure", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());    
	}
}
