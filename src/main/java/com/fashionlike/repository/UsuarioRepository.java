package com.fashionlike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fashionlike.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	@Procedure(procedureName = "PKG_FL_USUARIOS.SP_FL_REGISTRAR_USUARIO", outputParameterName = "OUT_MESSAGE")
    String registrarUsuario(
            @Param("IN_NOMBRE") String nombre,
            @Param("IN_APELLIDO_PATERNO") String apellidoPaterno,
            @Param("IN_APELLIDO_MATERNO") String apellidoMaterno,
            @Param("IN_EMAIL") String email,
            @Param("IN_PASSWORD") String password
    );
	

	Usuario findByEmail(String email);

	int deleteByEmail (String email);
}
