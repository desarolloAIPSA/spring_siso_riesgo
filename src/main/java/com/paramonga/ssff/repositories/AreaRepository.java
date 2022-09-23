package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.AreaTi;
import com.paramonga.ssff.entities.AreaTiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<AreaTi, AreaTiId> {

    @Query(value = "select * from vw_sgr_area ",nativeQuery = true)
    List<AreaTi> obtenerMaestro();

}
