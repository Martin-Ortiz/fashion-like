package com.fashionlike.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RequestManipularRegistro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private String nombre;

	
	private String apellidoPaterno;
	
	
	private String apellidoMaterno;
	
	@NotNull(message = "no debe ser nulo")
	@Email
	private String email;
 
	
}
