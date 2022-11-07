package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.VWPeligroRiesgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VWPeligroRiesgoRespository extends JpaRepository<VWPeligroRiesgo, Integer> {
}
