package com.fashionlike.exception;

import java.io.Serializable;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericExceptionHandler implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	int status;
	String fecha;
	String mensaje;
	List<?> detalles;
}
