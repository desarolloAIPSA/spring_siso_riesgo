package com.paramonga.ssff.services;

import com.paramonga.ssff.entities.DetPeligroRiesgo;

import java.util.List;

public interface DetPeligroRiesgoService {

    DetPeligroRiesgo getDetPeligroRiesgo(Integer codigo);
    List<DetPeligroRiesgo> crearPeligroRiesgo(List<DetPeligroRiesgo> input);


}
