package com.ayd.aulas.entity.compositeKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoMateriaEstudianteKey implements Serializable {

    @Column(name = "grupo_id")
    private Long grupoId;

    @Column(name = "materia_id")
    private Long materiaId;

    @Column(name = "estudiante_id")
    private Long estudianteId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoMateriaEstudianteKey that = (GrupoMateriaEstudianteKey) o;
        return Objects.equals(grupoId, that.grupoId) &&
                Objects.equals(materiaId, that.materiaId) &&
                Objects.equals(estudianteId, that.estudianteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupoId, materiaId, estudianteId);
    }
}
