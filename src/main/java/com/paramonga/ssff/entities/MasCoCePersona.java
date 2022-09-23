package com.paramonga.ssff.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "bs_contacto_cercano_persona")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MasCoCePersona {

    @Id
    @Column(name = "nro_doc", nullable = false)
    private String nroDoc;

    @Column(name = "nombres")
    private String nombres;

}
