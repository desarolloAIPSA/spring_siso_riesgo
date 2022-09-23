package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "vw_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {

    @EmbeddedId
    private UsuarioId id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipodoc")
    private String tipodoc;

    @Column(name = "nrodoc")
    private String nrodoc;

    @Column(name = "clave")
    private String clave;


}
