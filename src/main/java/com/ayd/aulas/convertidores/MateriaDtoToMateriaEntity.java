package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.MateriaDto;
import com.ayd.aulas.entity.MateriaEntity;
import org.springframework.stereotype.Component;

@Component
public class MateriaDtoToMateriaEntity {


    public MateriaEntity dtoResponseToEntity(MateriaDto dto) {
        MateriaEntity entity = new MateriaEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
