package com.ayd.aulas.entity;

import com.ayd.aulas.entity.compositeKey.GrupoMateriaKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "grupo_materia")
@NoArgsConstructor
@AllArgsConstructor
public class GrupoMateriaEntity {

    @EmbeddedId
    GrupoMateriaKey id;

    @ManyToOne
    @MapsId("grupoId")
    @JoinColumn(name = "grupo_id")
    @ToString.Exclude
    private GrupoEntity grupo;

    @ManyToOne
    @MapsId("materiaId")
    @JoinColumn(name = "materia_id")
    @ToString.Exclude
    private MateriaEntity materia;
}
