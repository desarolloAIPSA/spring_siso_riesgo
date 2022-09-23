package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.MasCoCePersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoCePersonaRepository extends JpaRepository<MasCoCePersona,String> {

    @Query(value = "select count(*) from bs_contacto_cercano_persona t where t.flag_estado='1' ",nativeQuery = true)
    Integer contar();


    @Query(value = "select t.nro_doc,t.nombres from bs_contacto_cercano_persona t where t.flag_estado='1' ",nativeQuery = true)
    List<MasCoCePersona> obtenerMaestro();

}
