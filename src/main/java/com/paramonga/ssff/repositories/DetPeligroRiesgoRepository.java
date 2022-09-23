package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.DetPeligroRiesgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetPeligroRiesgoRepository extends JpaRepository<DetPeligroRiesgo, String> {

    DetPeligroRiesgo findByCodPeligRies(Integer codigo);

}
