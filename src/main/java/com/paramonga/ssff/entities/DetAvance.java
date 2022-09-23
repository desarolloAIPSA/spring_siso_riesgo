package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SGR_DH_DC_AVANCE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetAvance {

    @Id
    @Column(name = "cod_avance", nullable = false)
    private Integer codAvance;

    @Column(name = "cod_hallazgo")
    private String codHallazgo;

    @Column(name = "cod_compromiso")
    private Integer codCompromiso;

    @Column(name = "avance")
    private Integer avance;

    @Column(name = "flag_estado")
    private String flagEstado;


}
