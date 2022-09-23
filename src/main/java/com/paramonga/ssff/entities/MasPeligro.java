package com.paramonga.ssff.entities;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SGR_PELIGRO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MasPeligro {

    @Id
    @Column(name = "COD_PELIGRO", nullable = false)
    private Integer codPeligro;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FLAG_ESTADO")
    private String flagEstado;


}
