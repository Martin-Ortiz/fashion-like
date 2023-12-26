package com.fashionlike.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionlike.entity.Usuario;
import com.fashionlike.request.RequestManipularRegistro;
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
	public ResponseEntity<?> guardarUsuario(@Valid @RequestBody RequestRegistro requestRegistro){
		HashMap<String, String> mensajes = new HashMap<>();
		
		String mensaje = service.registrarUsuario(requestRegistro);
		mensajes.put("Mensaje", mensaje);
		return new ResponseEntity<>(mensajes, HttpStatus.OK);
	}
	
	@PostMapping("/eliminar")
	public ResponseEntity<?> postEliminarUsuario(@Valid @RequestBody RequestManipularRegistro datosRegistro) {
		Map<String, String> mensajes = new HashMap<>();
		
		String mensaje = service.eliminarUsuario(datosRegistro);
		mensajes.put("Mensaje", mensaje);
		return new ResponseEntity<>(mensajes, HttpStatus.OK);
	}
	
	
}
