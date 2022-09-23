package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "SGR_DH_DC_REPROGRAMAR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetReprogramar {

    @Id
    @Column(name = "cod_reprogramacion", nullable = false)
    private Integer codReprogramacion;

    @Column(name = "cod_hallazgo")
    private String codHallazgo;

    @Column(name = "cod_compromiso")
    private Integer codCompromiso;

    @Column(name = "fecha_reprogramac")
    private LocalDateTime fechaReprogramac;

    @Column(name = "justificacion")
    private String justificacion;

    @Column(name = "usr_registra")
    private String usrRegistra;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "estacion_registra")
    private String estacionRegistra;

}
