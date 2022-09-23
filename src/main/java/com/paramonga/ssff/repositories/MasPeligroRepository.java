package com.paramonga.ssff.repositories;


import com.paramonga.ssff.entities.MasPeligro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasPeligroRepository extends JpaRepository<MasPeligro, String> {
}
