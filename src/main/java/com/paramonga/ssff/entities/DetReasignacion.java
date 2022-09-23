package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "SGR_DH_REASIGNACION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetReasignacion {

    @Id
    @Column(name = "cod_reasignacion", nullable = false)
    private Integer codReasignacion;

    @Column(name = "cod_hallazgo", nullable = false)
    private String codHallazgo;

    @Column(name = "usr_antiguo")
    private String usrAntiguo;

    @Column(name = "usr_nuevo")
    private String usrNuevo;

    @Column(name = "fecha_ini_reasignacion")
    private LocalDateTime fechaIniReasignacion;

    @Column(name = "fecha_fin_reasignacion")
    private LocalDateTime fechaFinReasignacion;

    @Column(name = "usr_registro")
    private String usrRegistro;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "estacion_registro")
    private String estacionRegistro;


}
