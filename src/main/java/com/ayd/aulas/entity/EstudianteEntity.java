package com.ayd.aulas.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "estudiante")
public class EstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private boolean repitente;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    @OneToMany(
            mappedBy = "estudiante",
            fetch = FetchType.LAZY
    )
    private List<GrupoEstudianteEntity> grupoEstudiante;
}
