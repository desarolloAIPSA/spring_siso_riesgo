package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "SGR_DH_COMPROMISO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetCompromiso {
    @Id
    @Column(name = "cod_compromiso", nullable = false)
    private Integer codCompromiso;

    @Column(name = "cod_hallazgo")
    private String codHallazgo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_compromiso")
    private LocalDateTime fechaCompromiso;

    @Column(name = "desc_observ")
    private String descObserv;

    @Column(name = "fecha_cierre_compr")
    private LocalDateTime fechaCierreCompr;

    @Column(name = "usr_verificacion")
    private String usrVerificacion;

    @Column(name = "fecha_verificacion")
    private LocalDateTime fechaVerificacion;

    @Column(name = "flag_verificacion")
    private String flagVerificacion;

    @Column(name = "estacion_verificacion")
    private String estacionVerificacion;

    @Column(name = "fecha_reprogramacion")
    private LocalDateTime fechaReprogramacion;
}
