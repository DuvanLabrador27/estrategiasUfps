package com.ayd.aulas.entity;

import com.ayd.aulas.entity.intermedias.ClaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "docente")
public class DocenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(
            mappedBy = "docente",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @ToString.Exclude
    private List<ClaseEntity> anioGrupos;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String username;
    private String password;



}
