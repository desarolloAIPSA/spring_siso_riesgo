package com.paramonga.ssff.services;

import com.paramonga.ssff.entities.CabHallazgo;

public interface DetHallazgoService {

    CabHallazgo getHallazgo(String codigo);
    CabHallazgo crearHallazgo(CabHallazgo input);

}
