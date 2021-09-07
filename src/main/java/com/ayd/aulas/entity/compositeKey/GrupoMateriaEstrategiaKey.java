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
public class GrupoMateriaEstrategiaKey implements Serializable {

    @Column(name = "grupo_id")
    private Long grupo;

    @Column(name = "materia_id")
    private Long materia;

    @Column(name = "estrategia_id")
    private Long estrategia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoMateriaEstrategiaKey that = (GrupoMateriaEstrategiaKey) o;
        return Objects.equals(grupo, that.grupo) &&
                Objects.equals(materia, that.materia) &&
                Objects.equals(estrategia, that.estrategia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupo, materia, estrategia);
    }
}
