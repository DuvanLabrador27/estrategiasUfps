package com.ayd.aulas.entity;

import com.ayd.aulas.entity.compositeKey.GrupoMateriaEstrategiaKey;
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
@Table(name = "grupo_materia_estrategia")
@NoArgsConstructor
public class GrupoMateriaEstrategiaEntity {

    @EmbeddedId
    GrupoMateriaEstrategiaKey id;

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

    @ManyToOne
    @MapsId("estrategiaId")
    @JoinColumn(name = "estrategia_id")
    @ToString.Exclude
    private EstrategiaEntity estrategia;

    public GrupoMateriaEstrategiaEntity(GrupoEntity grupo, MateriaEntity materia, EstrategiaEntity estrategia) {
        generarId();
        this.grupo = grupo;
        this.materia = materia;
        this.estrategia = estrategia;
    }

    private void generarId() {
        GrupoMateriaEstrategiaKey id = new GrupoMateriaEstrategiaKey(
                this.grupo.getId(),
                this.materia.getId(),
                this.estrategia.getId()
        );
        this.id = id;
    }
}
