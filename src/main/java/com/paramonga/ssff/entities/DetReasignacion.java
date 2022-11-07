package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "SGR_DH_REASIGNACION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetReasignacion {

    @Id
    @Column(name = "cod_reasignacion")
    @GeneratedValue(strategy=IDENTITY, generator = "SEQ_SGR_DH_REASIG")
    @SequenceGenerator(name = "SEQ_SGR_DH_REASIG", sequenceName = "SEQ_SGR_DH_REASIG",allocationSize = 1,initialValue = 1)
    private Integer codReasignacion;

    @Column(name = "cod_hallazgo")
    private Integer codHallazgo;

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
