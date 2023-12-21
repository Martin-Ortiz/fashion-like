package com.fashionlike.service;

import java.util.List;

import com.fashionlike.entity.Usuario;
import com.fashionlike.request.RequestRegistro;

public interface IUsuarioService {
	List<Usuario> listarUsuarios();
	
	String registrarUsuario(RequestRegistro datosRegistro);
}
