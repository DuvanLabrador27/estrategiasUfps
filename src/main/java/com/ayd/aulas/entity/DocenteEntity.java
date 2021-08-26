package com.ayd.aulas.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "docente")
public class DocenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    @OneToMany(
            mappedBy = "docente",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<GrupoEntity> grupos;

}
