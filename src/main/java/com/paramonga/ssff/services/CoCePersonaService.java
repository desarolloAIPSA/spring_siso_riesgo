package com.paramonga.ssff.services;

import com.paramonga.ssff.entities.MasCoCePersona;

import java.util.List;

public interface CoCePersonaService {

    List<MasCoCePersona> obtenerMaestroTrabajadores();

    Integer maestroSize();

}
