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
public class AreaTiId implements Serializable {

    @Column(name = "COD_AREA")
    private String codArea;

    @Column(name = "cod_seccion")
    private String codSeccion;
}
