package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.DetReasignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetReasignacionRepository extends JpaRepository<DetReasignacion, String> {

    DetReasignacion findByCodReasignacion(Integer codigo);
}
