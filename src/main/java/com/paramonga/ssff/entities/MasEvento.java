package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SGR_EVENTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MasEvento {

    @Id
    @Column(name = "COD_EVENTO", nullable = false)
    private Integer codEvento;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FLAG_ESTADO")
    private String flagEstado;

}
