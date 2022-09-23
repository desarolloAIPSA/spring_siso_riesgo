package com.paramonga.ssff.mapper;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class AreaTiMapper {
    private String codArea;
    private String codSeccion;
    private String codJefeSeccion;
    private String descSeccion;
    private String descArea;
    private String codTrabajador;
    private String nombre1;
    private String nombre2;
    private String apelPaterno;
    private String apelMaterno;
}
