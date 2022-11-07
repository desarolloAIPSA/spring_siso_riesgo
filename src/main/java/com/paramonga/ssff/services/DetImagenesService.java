package com.paramonga.ssff.services;

import com.paramonga.ssff.entities.DetImagenes;

import java.util.List;

public interface DetImagenesService {

    DetImagenes getDetImagenesService(Integer codigo);
    DetImagenes crearDetImagenes(DetImagenes input) throws  Exception;
    List<DetImagenes> crearDetImagenesList(List<DetImagenes> input) throws  Exception;

}
