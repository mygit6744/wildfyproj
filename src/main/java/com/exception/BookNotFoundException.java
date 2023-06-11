package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
	    value = HttpStatus.NOT_FOUND, 
	    reason = "Requested Book does not exist"
	)
public class BookNotFoundException extends RuntimeException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String string) {
		    super(string);
		  }
}
