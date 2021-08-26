package com.ayd.aulas.convertidores.mappers;

import com.ayd.aulas.dto.MateriaDto;
import com.ayd.aulas.entity.MateriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MateriaMapper {

    MateriaMapper INSTANCIA = Mappers.getMapper(MateriaMapper.class);


    MateriaDto aulaEnityToAulaDto(MateriaEntity materiaEntity);

    MateriaEntity aulaDtoToAulaEntity(MateriaDto materiaDto);
}
