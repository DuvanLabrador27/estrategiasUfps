package com.ayd.aulas.entity;

import com.ayd.aulas.entity.compositeKey.GrupoEstudianteKey;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "grupo_estudiante")
public class GrupoEstudianteEntity {

    @EmbeddedId
    private GrupoEstudianteKey id;

    @ManyToOne
    @MapsId("grupoId")
    @JoinColumn(name = "grupo_id")
    private GrupoEntity grupo;

    @ManyToOne
    @MapsId("estudianteId")
    @JoinColumn(name = "estudiante_id")
    private EstudianteEntity estudiante;
}
