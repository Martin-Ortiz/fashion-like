package com.fashionlike.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionlike.entity.Usuario;
import com.fashionlike.repository.UsuarioRepository;
import com.fashionlike.request.RequestRegistro;
import com.fashionlike.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return repository.findAll();
	}

	@Override
	public String registrarUsuario(RequestRegistro datosRegistro) {
		
		String[] outMessage = repository.callRegistrarUsuario(
				datosRegistro.getNombre(),
				datosRegistro.getApellidoPaterno(),
				datosRegistro.getApellidoMaterno(),
				datosRegistro.getEmail(),
				datosRegistro.getPassword()
        );

        // Puedes hacer algo con el resultado, como imprimirlo en el registro o manejarlo de otra manera.
        System.out.println("Resultado del procedimiento almacenado: " + String.join(", ", outMessage));
		
		
		
		return outMessage[0];
	}

}
