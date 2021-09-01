package com.ayd.aulas.convertidores.mappers;

import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.GrupoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GrupoMapper {

    GrupoMapper INSTANCIA = Mappers.getMapper(GrupoMapper.class);

    GrupoEntity grupoDtoToGrupoEntity(GrupoDto grupoDto);

    GrupoDto grupoEntityToGrupoDto(GrupoEntity grupoEntity);
}
