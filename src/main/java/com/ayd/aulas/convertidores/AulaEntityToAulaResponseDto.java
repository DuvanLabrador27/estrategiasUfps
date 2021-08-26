package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.AulaResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AulaEntityToAulaResponseDto {

    public AulaResponseDto entityToResponseDto(MateriaEntity entity) {
        AulaResponseDto dto = new AulaResponseDto();
        dto.setGrupos(new ArrayList<>());
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        entity.getGrupos().forEach(
                entityG -> dto.getGrupos().add(entityG.getId())
        );
        return dto;
    }
}
