package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.DetReprogramar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetReprogramarRepository extends JpaRepository<DetReprogramar, String> {

    DetReprogramar findByCodReprogramacion(Integer codigo);
}
