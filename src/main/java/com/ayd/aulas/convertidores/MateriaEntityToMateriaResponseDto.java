package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.MateriaResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MateriaEntityToMateriaResponseDto {

    public MateriaResponseDto entityToResponseDto(MateriaEntity entity) {
        MateriaResponseDto dto = new MateriaResponseDto();
        dto.setGrupos(new ArrayList<>());
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        entity.getGrupos().forEach(
                entityG -> dto.getGrupos().add(entityG.getId())
        );
        return dto;
    }
}
