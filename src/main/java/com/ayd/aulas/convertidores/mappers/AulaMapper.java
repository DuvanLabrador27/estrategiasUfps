package com.ayd.aulas.convertidores.mappers;

import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.entity.MateriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AulaMapper {

    AulaMapper INSTANCIA = Mappers.getMapper(AulaMapper.class);


    AulaDto aulaEnityToAulaDto(MateriaEntity materiaEntity);

    MateriaEntity aulaDtoToAulaEntity(AulaDto aulaDto);
}
