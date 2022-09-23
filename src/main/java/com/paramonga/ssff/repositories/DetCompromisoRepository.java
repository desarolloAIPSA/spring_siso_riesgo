package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.DetCompromiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetCompromisoRepository extends JpaRepository<DetCompromiso, String> {

    DetCompromiso findByCodCompromiso(Integer codigo);

}
