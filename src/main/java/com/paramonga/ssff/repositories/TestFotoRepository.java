package com.paramonga.ssff.repositories;

import com.paramonga.ssff.entities.TestFoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestFotoRepository extends JpaRepository<TestFoto,String> {



}
