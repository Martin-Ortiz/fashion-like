package com.fashionlike.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RequestRegistro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String password;

}
