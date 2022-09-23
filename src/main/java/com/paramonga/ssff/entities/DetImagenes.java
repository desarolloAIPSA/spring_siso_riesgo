package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "SGR_DH_IMAGENES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetImagenes {

    @Id
    @Column(name = "cod_imagen", nullable = false)
    private Integer codImagen;

    @Column(name = "cod_hallazgo")
    private String codHallazgo;

    @Column(name = "ruta")
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
