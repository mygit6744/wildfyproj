package com.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dto.ErrorResponse;

@ControllerAdvice
class ValidateParametersController  {

	  // request mapping method omitted
	  
	  @ExceptionHandler(ConstraintViolationException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {
	    List<String> details = new ArrayList<>();
	    details.add(e.getMessage());
	    ErrorResponse error = new ErrorResponse("validation error", details);
	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	  }

	}