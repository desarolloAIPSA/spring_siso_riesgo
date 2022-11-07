package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name = "SGR_DH_IMAGENES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetImagenes implements Serializable {

    @Id
    @Column(name = "cod_imagen")
    @GeneratedValue(strategy=IDENTITY, generator = "SEQ_SGR_DH_IMAGENES")
    @SequenceGenerator(name = "SEQ_SGR_DH_IMAGENES", sequenceName = "SEQ_SGR_DH_IMAGENES",allocationSize = 1,initialValue = 1)
    private Integer codImagen;

    @Column(name = "cod_hallazgo")
    private Integer codHallazgo;

    @Column(name = "RUTA")
    private String ruta;

    @Column(name = "flag_estado")
    private String flagEstado;

    @Column(name = "usr_registro")
    private String usrRegistro;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "estacion_registro")
    private String estacionRegistro;


}
