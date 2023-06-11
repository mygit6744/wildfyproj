package com.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dto.ErrorDTO;
 
@ControllerAdvice
public class GlobalExceptionHandler {
     
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
 
 
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO handleConstraintViolationException(HttpServletRequest request, Exception ex) {
        ErrorDTO error = new ErrorDTO();
         
        error.setTimestamp(new Date());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.addError(ex.getMessage());
        error.setPath(request.getServletPath());
         
        LOGGER.error(ex.getMessage(), ex);
         
        return error;
    }  
     
}