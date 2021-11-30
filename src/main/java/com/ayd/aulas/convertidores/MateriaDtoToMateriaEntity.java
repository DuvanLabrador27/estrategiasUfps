package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.dto.MateriaDto;
import com.ayd.aulas.entity.MateriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MateriaDtoToMateriaEntity {

    @Autowired
    private GrupoDao grupoDao;

    public MateriaEntity dtoResponseToEntity(MateriaDto dto) {
        MateriaEntity entity = new MateriaEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }
}
