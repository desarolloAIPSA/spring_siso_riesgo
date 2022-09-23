package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.MasRiesgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasRiesgoRepository extends JpaRepository<MasRiesgo, String> {
}
