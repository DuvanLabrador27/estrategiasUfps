package com.ayd.aulas.entity;

import com.ayd.aulas.entity.compositeKey.GrupoMateriaKey;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Data
public class GrupoMateriaEntity {

    @EmbeddedId
    GrupoMateriaKey id;

    @ManyToOne
    @MapsId("grupoId")
    @JoinColumn(name = "grupo_id")
    private GrupoEntity grupo;

    @ManyToOne
    @MapsId("materiaId")
    @JoinColumn(name = "materia_id")
    private MateriaEntity materia;
}
