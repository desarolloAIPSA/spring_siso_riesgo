package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_SGR_PELIGRO_RIESGO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VWPeligroRiesgo {

    @Id
    @Column(name = "COD_PELIGRO_RIESGO", nullable = false)
    private Integer codPeligroRiesgo;

    @Column(name = "COD_PELIGRO")
    private Integer codPeligro;

    @Column(name = "PELIGRO")
    private String peligro;

    @Column(name = "COD_RIESGO")
    private Integer codRiesgo;

    @Column(name = "RIESGO")
    private String riesgo;

}
