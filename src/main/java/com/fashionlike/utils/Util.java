package com.fashionlike.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fashionlike.entity.Usuario;
import com.fashionlike.exception.ErrorDTO;
import com.fashionlike.request.RequestManipularRegistro;

public class Util {
	
	public static String formatearFecha(LocalDateTime fecha) {
		LocalDateTime now = fecha;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		return now.format(formatter);
		
	}
	
	public static List<ErrorDTO> errorsNotValidException(MethodArgumentNotValidException ex){
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		
		List<ErrorDTO> errorsDTO = new ArrayList<>();
		
		for(FieldError fieldError : fieldErrors) {
			
			errorsDTO.add(new ErrorDTO("El atributo: " + fieldError.getField() + ", " + fieldError.getDefaultMessage(), "400"));
		}
		return errorsDTO;
	}
	
	public static Usuario validarDatos(Usuario usuario, RequestManipularRegistro datosUsuario) {
		Usuario datosDB = usuario;
		
		System.out.println("ValidarDatos---> Usuario:" + usuario);
		System.out.println("ValidarDatos---> RequestManipularRegistro" +datosUsuario);
		if (datosUsuario.getNombre() != null && !datosUsuario.getNombre().isEmpty()) {
            datosDB.setNombre(datosUsuario.getNombre());
        }

        if (datosUsuario.getApellidoPaterno() != null && !datosUsuario.getApellidoPaterno().isEmpty()) {
            datosDB.setApellidoPaterno(datosUsuario.getApellidoPaterno());
        }

        if (datosUsuario.getApellidoMaterno() != null && !datosUsuario.getApellidoMaterno().isEmpty()) {
            datosDB.setApellidoMaterno(datosUsuario.getApellidoMaterno());
        }
		return datosDB;
	}
}
