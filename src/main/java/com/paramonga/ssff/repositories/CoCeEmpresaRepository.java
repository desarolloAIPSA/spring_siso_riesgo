package com.paramonga.ssff.repositories;


import com.paramonga.ssff.entities.MasCoCeEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoCeEmpresaRepository extends JpaRepository<MasCoCeEmpresa,String> {

    @Query(value = "select * from bs_contacto_cercano_empresa t where t.flag_estado='1' ",nativeQuery = true)
    List<MasCoCeEmpresa> obtenerMaestro();


}
