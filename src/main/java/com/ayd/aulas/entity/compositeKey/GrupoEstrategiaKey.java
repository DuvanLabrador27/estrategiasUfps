package com.ayd.aulas.entity.compositeKey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class GrupoEstrategiaKey implements Serializable {

    @Column(name = "grupo_id")
    private Long grupoId;

    @Column(name = "estrategia_id")
    private Long estrategiaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoEstrategiaKey that = (GrupoEstrategiaKey) o;
        return Objects.equals(grupoId, that.grupoId) &&
                Objects.equals(estrategiaId, that.estrategiaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupoId, estrategiaId);
    }
}
