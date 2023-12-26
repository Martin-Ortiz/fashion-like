package com.fashionlike.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fashionlike.exception.ErrorDTO;

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
}
