package com.paramonga.ssff.entities;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SGR_PELIGRO_RIESGO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MasPeligroRiesgo {

    @Id
    @Column(name = "COD_PELIGRO_RIESGO", nullable = false)
    private Integer codPeligroRiesgo;

    @Column(name = "COD_PELIGRO")
    private Integer codPeligro;

    @Column(name = "COD_RIESGO")
    private Integer codRiesgo;

    @Column(name = "FLAG_ESTADO")
    private String flagEstado;


}
