package com.ayd.aulas.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "grupo")
public class GrupoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private MateriaEntity aula;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private DocenteEntity docente;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @ToString.Exclude
    private EstudianteEntity estudiantes;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "grupos")
    private List<EstrategiaEntity> estrategias;

    @Override
    public String toString() {
        return "GrupoEntity{}";
    }
}
