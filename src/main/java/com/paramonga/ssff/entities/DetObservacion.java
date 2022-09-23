package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "SGR_DH_DC_OBSERVACION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetObservacion {

    @Id
    @Column(name = "cod_observ", nullable = false)
    private Integer codObserv;

    @Column(name = "cod_hallazgo")
    private String codHallazgo;

    @Column(name = "cod_compromiso")
    private Integer codCompromiso;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "flag_estado")
    private String flagEstado;

    @Column(name = "usr_registro")
    private String usrRegistro;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "estacion_registro")
    private String estacionRegistro;



}
