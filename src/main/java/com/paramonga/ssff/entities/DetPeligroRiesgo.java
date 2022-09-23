package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "SGR_DH_PELIGRO_RIESGO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetPeligroRiesgo {

    @Id
    @Column(name = "cod_pelig_ries", nullable = false)
    private Integer codPeligRies;

    @Column(name = "cod_peligro_riesgo", nullable = false)
    private Integer codPeligroRiesgo;

    @Column(name = "cod_hallazgo", nullable = false)
    private String codHallazgo;

    @Column(name = "usr_registra")
    private String usrRegistra;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "estacion_registro")
    private String estacionRegistro;

    @Column(name = "flag_estado")
    private String flagEstado;


}
