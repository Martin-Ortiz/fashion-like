package com.fashionlike.repository;

import javax.persistence.StoredProcedureQuery;

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

    default String[] callRegistrarUsuario(
            String nombre,
            String apellidoPaterno,
            String apellidoMaterno,
            String email,
            String password
    ) {
        // Llamar al procedimiento almacenado y obtener el resultado como String
        String outMessage = registrarUsuario(nombre, apellidoPaterno, apellidoMaterno, email, password);

        // Crear un array de String para que sea compatible con tu método
        String[] outMessageArray = new String[]{outMessage};

        return outMessageArray;
    }
}
