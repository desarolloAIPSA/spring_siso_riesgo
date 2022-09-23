package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.MasEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasEventoRepository extends JpaRepository<MasEvento, String> {

    @Query(value = "select t.* from SGR_EVENTO t where t.flag_estado='1' ",nativeQuery = true)
    List<MasEvento> obtenerMaestro();

}
