package com.ayd.aulas.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "grupo")
@ToString
public class GrupoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;


    @ManyToOne()
    @ToString.Exclude
    private DocenteEntity docente;

    @OneToMany(
            mappedBy = "grupo",
            fetch = FetchType.LAZY
    )
    private List<GrupoMateriaEstudianteEntity> grupoMateriaEstudiante;

    @OneToMany(
            mappedBy = "grupo",
            fetch = FetchType.LAZY
    )
    private List<GrupoMateriaEstrategiaEntity> grupoMateriaEstrategia;


}
