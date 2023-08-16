package com.freigtmate.task.advice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * @author hitesh.bidve
 * @implNote RestControllerAdvice for handling exceptions and resolve with custom messages.
 */
@RestControllerAdvice
public class GlobalExceptionHandler 
{
	private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class);
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) 
	{
		List<String> errors = ex.getBindingResult()
								.getFieldErrors()
								.stream()
								.map(FieldError::getDefaultMessage)
								.collect(Collectors.toList());
		log.error("One or may be more Validation Failed,Please check", ex.getMessage());
		
		return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	

	private Map<String, List<String>> getErrorsMap(List<String> errors) 
	{
		Map<String, List<String>> errorResponse = new HashMap<>();
		errorResponse.put("errors", errors);
		
		return errorResponse;
	}

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, List<String>>> handleResourceNotFoundException(ResourceNotFoundException ex) 
	{
	    List<String> errors = Collections.singletonList(ex.getMessage());
	    
	    log.error("ResourceNotFoundException Occurs", ex.getMessage());
	    
	    return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String, List<String>>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) 
	{
	    List<String> errors = Collections.singletonList(ex.getMessage());
	    
	    log.error("DataIntegrityViolationException Occurs", ex.getMessage());
	    
	    return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, List<String>>> handleConstraintViolationException(Exception ex) 
	{
	    List<String> errors = Collections.singletonList(ex.getMessage());
	    
	    log.error("Internal Server Esception Occurs.", ex.getMessage());
	    
	    return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
