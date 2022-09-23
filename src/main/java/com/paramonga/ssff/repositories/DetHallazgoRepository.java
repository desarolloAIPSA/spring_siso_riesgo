package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.DetHallazgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetHallazgoRepository extends JpaRepository<DetHallazgo, String> {

    DetHallazgo findByCodHallazgo(String codigo);

}
