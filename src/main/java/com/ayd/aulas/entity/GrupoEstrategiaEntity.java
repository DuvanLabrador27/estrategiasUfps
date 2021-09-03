package com.ayd.aulas.entity;

import com.ayd.aulas.entity.compositeKey.GrupoEstrategiaKey;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "grupo_estrategia")
public class GrupoEstrategiaEntity {

    @EmbeddedId
    private GrupoEstrategiaKey id;

    @ManyToOne
    @MapsId("grupoId")
    @JoinColumn(name = "grupo_id")
    private GrupoEntity grupo;

    @ManyToOne
    @MapsId("estrategiaId")
    @JoinColumn(name = "estrategia_id")
    private EstrategiaEntity estrategia;
}
