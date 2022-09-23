package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioId implements Serializable {

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "grupo")
    private String grupo;
}
