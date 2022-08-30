package com.simple.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleResponses(Exception employeeException) {
		Response response = new Response();
		response.setError(true);
		response.setErrMessage(employeeException.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}
}
