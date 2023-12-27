package com.fashionlike.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	protected List<?> errors;
	
	protected int status;

	public GenericException() {
		super();
	}
	
	public GenericException(String message, int status) {
		super(message);
		this.status = status;
		
	}
	
	public GenericException(String message, List<?> errors, int status) {
		super(message);
		this.errors = errors;
		this.status = status;
	}
	
	public GenericException (String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
