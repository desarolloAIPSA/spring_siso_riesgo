package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SGR_HALLAZGO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetHallazgo {

    @Id
    @Column(name = "cod_hallazgo", unique = true, nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Integer codHallazgo;

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "cod_empresa")
    private String codEmpresa;

    @Column(name = "cod_evento")
    private Integer codEvento;

    @Column(name = "nro_doc")
    private String nroDoc;

    @Column(name = "acontecimiento")
    private String acontecimiento;

    @Column(name = "medida")
    private String medida;

    @Column(name = "usr_registra")
    private String usrRegistra;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "estacion_registro")
    private String estacionRegistro;

    @Column(name = "usr_responsable")
    private String usrResponsable;

    @Column(name = "cod_area")
    private String codArea;

    @Column(name = "cod_seccion")
    private String codSeccion;

    @Column(name = "flag_estado")
    private String flagEstado;

    @Column(name = "usr_cierre")
    private String usrCierre;

    @Column(name = "fecha_cierre")
    private LocalDateTime fechaCierre;

    @Column(name = "estacion_cierre")
    private String estacionCierre;

    @Column(name = "prioridad")
    private String prioridad;

}
