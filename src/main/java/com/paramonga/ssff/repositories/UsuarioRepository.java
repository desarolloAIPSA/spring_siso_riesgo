package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.Usuario;
import com.paramonga.ssff.entities.UsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioId> {

    @Query(value = "select * from vw_usuario t where t.usuario=:#{#user} and t.grupo=:#{#grupo} and t.clave=:#{#password}",nativeQuery = true)
    Usuario obtener(String user,String grupo,String password);
}
