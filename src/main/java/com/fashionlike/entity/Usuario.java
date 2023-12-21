package com.fashionlike.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "ID_USUARIO")
	private String idUsuario;
	
	private String nombre;
	
	@Column (name = "APELLIDO_PATERNO")
	private String apellidoPaterno;
	
	@Column (name = "APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	private String email;
	
	@Column (name = "ID_PASSWORD")
	private String idPassword;
	
	@Column (name = "FECHA_REGISTRO")
	private Date fechaRegistro;
	
}
