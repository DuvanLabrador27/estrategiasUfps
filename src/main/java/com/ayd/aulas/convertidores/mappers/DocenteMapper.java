package com.ayd.aulas.convertidores.mappers;

import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.entity.DocenteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocenteMapper {

    DocenteMapper INSTANCIA = Mappers.getMapper(DocenteMapper.class);


    DocenteDto aulaEnityToAulaDto(DocenteEntity docenteEntity);

    DocenteEntity aulaDtoToAulaEntity(DocenteDto docenteDto);
}
