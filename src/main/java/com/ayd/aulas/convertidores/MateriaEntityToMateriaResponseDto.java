package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.MateriaResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MateriaEntityToMateriaResponseDto {

    public MateriaResponseDto entityToResponseDto(MateriaEntity entity) {
        MateriaResponseDto dto = new MateriaResponseDto();
        dto.setGrupos(new ArrayList<>());
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        List<Long> grupos = new ArrayList<>();
        entity.getGrupoMateriaEntities().forEach(
                (grupoMateria) -> {
                    grupos.add(
                            grupoMateria.getGrupo().getId()
                    );
                }
        );
        dto.setGrupos(grupos);
        return dto;
    }
}
