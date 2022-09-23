package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "vw_sgr_area")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AreaTi {

    @EmbeddedId
    private AreaTiId id;

    @Column(name = "cod_jefe_seccion")
    private String codJefeSeccion;

    @Column(name = "desc_seccion")
    private String descSeccion;

    @Column(name = "desc_area")
    private String descArea;

    @Column(name = "cod_trabajador")
    private String codTrabajador;

    @Column(name = "nombre1")
    private String nombre1;

    @Column(name = "nombre2")
    private String nombre2;

    @Column(name = "apel_paterno")
    private String apelPaterno;

    @Column(name = "apel_materno")
    private String apelMaterno;



}
