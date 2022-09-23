package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bs_contacto_cercano_empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MasCoCeEmpresa {

    @Id
    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

}
