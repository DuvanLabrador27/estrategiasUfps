package com.ayd.aulas.entity.compositeKey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class GrupoMateriaKey implements Serializable {

    @Column(name = "grupo_id")
    private Long grupoId;

    @Column(name = "materia_id")
    private Long materiaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoMateriaKey that = (GrupoMateriaKey) o;
        return Objects.equals(grupoId, that.grupoId) &&
                Objects.equals(materiaId, that.materiaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupoId, materiaId);
    }
}
