package com.ayd.aulas.entity;

import com.ayd.aulas.entity.intermedias.ClaseEstudianteEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "estudiante")
public class EstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @OneToMany(
            mappedBy = "estudiante",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<ClaseEstudianteEntity> anioGrupoEstudiantes;

    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private boolean repitente;

}
