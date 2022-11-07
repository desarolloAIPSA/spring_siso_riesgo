package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.CabHallazgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetHallazgoRepository extends JpaRepository<CabHallazgo, String> {

    CabHallazgo findByCodHallazgo(String codigo);

}
