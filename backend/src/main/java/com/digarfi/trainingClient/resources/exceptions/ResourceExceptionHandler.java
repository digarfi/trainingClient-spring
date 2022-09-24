package com.digarfi.trainingClient.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.digarfi.trainingClient.services.exceptions.DatabaseIntegrityException;
import com.digarfi.trainingClient.services.exceptions.ResourceNotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
			HttpStatus status = HttpStatus.NOT_FOUND;
			StandardError err = new StandardError();
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Resource Not Found");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}
	
	
	@ExceptionHandler(DatabaseIntegrityException.class)
	public ResponseEntity<StandardError> databaseIntegrity(DatabaseIntegrityException e, HttpServletRequest request){
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError();
			err.setTimestamp(Instant.now());
			err.setStatus(status.value());
			err.setError("Database Integrity Exception");
			err.setMessage(e.getMessage());
			err.setPath(request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}
	
	
}
	
	

