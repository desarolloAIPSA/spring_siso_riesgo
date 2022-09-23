package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.DetAvance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetAvanceRepository extends JpaRepository<DetAvance, String> {

    DetAvance findByCodAvance(Integer codigo);

}
