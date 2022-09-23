package com.paramonga.ssff.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "test_foto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestFoto {
    @Id
    @Column(name = "ID")
    String id;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    @Column(name = "FOTO")
    byte[] foto;
}
