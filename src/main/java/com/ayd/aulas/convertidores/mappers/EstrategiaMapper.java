package com.ayd.aulas.convertidores.mappers;

import com.ayd.aulas.dto.EstrategiaDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstrategiaMapper {

    EstrategiaMapper INSTANCIA = Mappers.getMapper(EstrategiaMapper.class);

    EstrategiaEntity estrategiaDtoToEstrategiaEntity(EstrategiaDto estrategiaDto);

    EstrategiaDto estrategiaEntityToEstrategiaDto(EstrategiaEntity estrategiaEntity);
}
