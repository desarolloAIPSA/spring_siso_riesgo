package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.DetImagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetImagenesRepository extends JpaRepository<DetImagenes, String> {

    DetImagenes findByCodImagen(Integer codigo);

}
