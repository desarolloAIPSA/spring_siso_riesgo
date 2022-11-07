package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "SGR_DH_PELIGRO_RIESGO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetPeligroRiesgo implements Serializable {

    @Id
    @Column(name = "cod_pelig_ries")
    @GeneratedValue(strategy=IDENTITY, generator = "SEQ_SGR_DH_PELIGRO_RIESGO")
    @SequenceGenerator(name = "SEQ_SGR_DH_PELIGRO_RIESGO", sequenceName = "SEQ_SGR_DH_PELIGRO_RIESGO",allocationSize = 1,initialValue = 1)
    private Integer codPeligRies;

    @Column(name = "cod_peligro_riesgo")
    private Integer codPeligroRiesgo;

    @Column(name = "cod_hallazgo")
    private Integer codHallazgo;

    @Column(name = "usr_registra")
    private String usrRegistra;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "estacion_registro")
    private String estacionRegistro;

    @Column(name = "flag_estado")
    private String flagEstado;


}
