package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.dto.MateriaDto;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.MateriaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrupoEntityToGrupoResponseDto {

    public static GrupoResponseDto entityToDto(GrupoEntity entity) {
        GrupoResponseDto dto = new GrupoResponseDto();
        dto.setEstrategias(new ArrayList<>());

        List<Long> materiaDtos = new ArrayList<>();
        entity.getMaterias().stream().map(
                materiaEntity -> materiaDtos.add(
                        materiaEntity.getId()
                )
        );

        dto.setDocente(Objects.nonNull(entity.getDocente())?entity.getDocente().getId() : 0);
        entity.getEstrategias().forEach(
                estrategia -> dto.getEstrategias().add(estrategia.getId())
        );
        dto.setEstudiantes(Objects.nonNull(entity.getEstudiantes())?entity.getEstudiantes().getId() : 0);
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }
}
