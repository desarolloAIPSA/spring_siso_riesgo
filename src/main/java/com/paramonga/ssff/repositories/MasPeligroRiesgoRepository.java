package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.MasPeligroRiesgo;
import com.paramonga.ssff.entities.MasPeligroRiesgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasPeligroRiesgoRepository extends JpaRepository<MasPeligroRiesgo, String> {

    @Query(value = "select t.*, t.rowid from SGR_PELIGRO_RIESGO t where t.flag_estado='1' ",nativeQuery = true)
    List<MasPeligroRiesgo> obtenerMaestro();

}
