package com.fashionlike.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionlike.entity.Usuario;
import com.fashionlike.request.RequestRegistro;
import com.fashionlike.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	IUsuarioService service;
	
	@PostMapping("/listar")
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List<Usuario> usuarios = service.listarUsuarios();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<String> guardarUsuario(@Valid @RequestBody RequestRegistro requestRegistro){
		String mensaje = service.registrarUsuario(requestRegistro);
		return new ResponseEntity<String>(mensaje, HttpStatus.OK);
	}
	
}
