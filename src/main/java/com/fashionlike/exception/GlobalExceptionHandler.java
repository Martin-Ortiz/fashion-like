package com.fashionlike.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fashionlike.utils.Util;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	//GenericExcption
	@ExceptionHandler(GenericException.class)
	protected ResponseEntity<Object> handleGenericException(GenericException ex){
		
		return ResponseEntity.status(ex.getStatus()).body(new GenericExceptionHandler(ex.getStatus(), Util.formatearFecha(LocalDateTime.now()), ex.getMessage(), ex.getErrors()));
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> detalles = new ArrayList<String>();
		detalles.add("Metodo no soportado.");
		GenericExceptionHandler responseError = new GenericExceptionHandler(HttpStatus.METHOD_NOT_ALLOWED.value(), Util.formatearFecha(LocalDateTime.now()), ex.getMessage(), detalles);
		
		return ResponseEntity.status(status).body(responseError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> detalles = new ArrayList<String>();
		detalles.add("Tipo de dato no permitido.");
		GenericExceptionHandler responseError = new GenericExceptionHandler(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), Util.formatearFecha(LocalDateTime.now()), ex.getMessage(), detalles);
		
		return ResponseEntity.status(status).body(responseError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> detalles = new ArrayList<String>();
		detalles.add("Tipo de dato no Aceptable.");
		GenericExceptionHandler responseError = new GenericExceptionHandler(HttpStatus.NOT_ACCEPTABLE.value(), Util.formatearFecha(LocalDateTime.now()), ex.getMessage(), detalles);
		
		return ResponseEntity.status(status).body(responseError);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> detalles = new ArrayList<String>();
		detalles.add("Se esperaba variable en el path.");
		GenericExceptionHandler responseError = new GenericExceptionHandler(HttpStatus.BAD_REQUEST.value(), Util.formatearFecha(LocalDateTime.now()), ex.getMessage(), detalles);
		
		return ResponseEntity.status(status).body(responseError);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> detalles = new ArrayList<String>();
		detalles.add("Se esperaba parametro en la peticion.");
		GenericExceptionHandler responseError = new GenericExceptionHandler(HttpStatus.BAD_REQUEST.value(), Util.formatearFecha(LocalDateTime.now()), ex.getMessage(), detalles);
		
		return ResponseEntity.status(status).body(responseError);
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleServletRequestBindingException(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleConversionNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> detalles = new ArrayList<String>();
		detalles.add("Tipo de dato incorrecto.");
		GenericExceptionHandler responseError = new GenericExceptionHandler(HttpStatus.BAD_REQUEST.value(), Util.formatearFecha(LocalDateTime.now()), ex.getMessage(), detalles);
		
		return ResponseEntity.status(status).body(responseError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> detalles = new ArrayList<String>();
		detalles.add("Falta informacion en el body.");
		GenericExceptionHandler responseError = new GenericExceptionHandler(HttpStatus.BAD_REQUEST.value(), Util.formatearFecha(LocalDateTime.now()), "Verifica el cuerpo del objeto", detalles);
		
		return ResponseEntity.status(status).body(responseError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleHttpMessageNotWritable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		GenericExceptionHandler responseError = new GenericExceptionHandler(HttpStatus.BAD_REQUEST.value(), Util.formatearFecha(LocalDateTime.now()), "Error al validar información.", Util.errorsNotValidException(ex));
		
		return ResponseEntity.status(status).body(responseError);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleMissingServletRequestPart(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleBindException(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleNoHandlerFoundException(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex,
			HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
		// TODO Auto-generated method stub
		return super.handleAsyncRequestTimeoutException(ex, headers, status, webRequest);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	
}
