package com.paramonga.ssff.entities;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SGR_RIESGO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MasRiesgo {

    @Id
    @Column(name = "COD_RIESGO")
    private Integer codRiesgo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FLAG_ESTADO")
    private String flagEstado;
}
