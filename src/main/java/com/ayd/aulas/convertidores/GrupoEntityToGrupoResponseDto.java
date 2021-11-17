package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.GrupoEntity;

import java.util.ArrayList;
import java.util.List;

public class GrupoEntityToGrupoResponseDto {

    public static GrupoResponseDto entityToDto(GrupoEntity entity) {
        GrupoResponseDto dto = new GrupoResponseDto();
        dto.setEstrategias(new ArrayList<>());
        dto.setEstudiantes(new ArrayList<>());

        List<Long> materiaDtos = new ArrayList<>();
        dto.setMaterias(materiaDtos);
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }
}
