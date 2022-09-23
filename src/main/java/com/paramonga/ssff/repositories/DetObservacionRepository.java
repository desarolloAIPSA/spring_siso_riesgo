package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.DetObservacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetObservacionRepository extends JpaRepository<DetObservacion, String> {

    DetObservacion findByCodObserv(Integer codigo);

}
