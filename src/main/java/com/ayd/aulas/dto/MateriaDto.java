package com.ayd.aulas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MateriaDto {
    private Long id;
    private String nombre;

    public MateriaDto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
