package com.fashionlike.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionlike.entity.Usuario;
import com.fashionlike.exception.GenericException;
import com.fashionlike.repository.PasswordRepository;
import com.fashionlike.repository.UsuarioRepository;
import com.fashionlike.request.RequestManipularRegistro;
import com.fashionlike.request.RequestRegistro;
import com.fashionlike.service.IUsuarioService;
import com.fashionlike.utils.Util;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	UsuarioRepository repositoryUser;
	
	@Autowired
	PasswordRepository repositoryPass;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return repositoryUser.findAll();
	}

	@Override
	public String registrarUsuario(RequestRegistro datosRegistro) {
		
		String outMessage = repositoryUser.registrarUsuario(
				datosRegistro.getNombre(),
				datosRegistro.getApellidoPaterno(),
				datosRegistro.getApellidoMaterno(),
				datosRegistro.getEmail(),
				datosRegistro.getPassword()
        );
		
        // Puedes hacer algo con el resultado, como imprimirlo en el registro o manejarlo de otra manera.
        System.out.println("Resultado del procedimiento almacenado: " + outMessage);
		
		
		
		return outMessage;
	}

	@Override
	@Transactional
	public String eliminarUsuario(RequestManipularRegistro datosRegistro) {
		
		Usuario eliminarUsuario = repositoryUser.findByEmail(datosRegistro.getEmail());
		System.out.println("Datos: " + eliminarUsuario);
		try {
			if (eliminarUsuario == null) {
				return "El usuario con email proporcionado no existe.";
			}else {
				
				int usuarioEliminado = repositoryUser.deleteByEmail(datosRegistro.getEmail());
				int passwordEliminado = repositoryPass.deleteByIdPassword(eliminarUsuario.getIdPassword());
				
				if(usuarioEliminado > 0 && passwordEliminado > 0) {
					return "Usuario eliminado con exito UwU: ";
				}else {
					throw  new RuntimeException("No se pudo eliminar el registro.");
				}
			}
		} catch (Exception e) {
			throw new GenericException("Error al eliminar el usuario.",400);
		}
		
		
		
	}

	@Override
	@Transactional
	public String actualizarUsuario(RequestManipularRegistro datosRegistro) {
		Usuario actualizarUsuario = repositoryUser.findByEmail(datosRegistro.getEmail());
		System.out.println("Datos: " + actualizarUsuario);
		System.out.println("Datos-Actualizacion: " + Util.validarDatos(actualizarUsuario, datosRegistro));
		
		if (actualizarUsuario != null) {
			Usuario datosActualizados = Util.validarDatos(actualizarUsuario, datosRegistro);
			if (datosActualizados.equals(actualizarUsuario)) {
				return "Sin datos para actualizar baby.";
			}
			try {
				repositoryUser.save(datosActualizados);
				return "Usuario Actualizado";
				
			} catch (Exception e) {
				throw new RuntimeException("Error al actualizar el usuario");
			}
			
		}else {
			return "El usuario con email proporcionado no existe.";
		}

	}
}
