package com.ayd.aulas.entity.compositeKey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class GrupoEstudianteKey implements Serializable {

    @Column(name = "grupo_id")
    private Long grupoId;

    @Column(name = "materia_id")
    private Long estudianteId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoEstudianteKey that = (GrupoEstudianteKey) o;
        return Objects.equals(grupoId, that.grupoId) &&
                Objects.equals(estudianteId, that.estudianteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupoId, estudianteId);
    }
}
