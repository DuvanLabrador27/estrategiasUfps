package com.ayd.aulas.convertidores.mappers;

import com.ayd.aulas.dto.EstudianteDto;
import com.ayd.aulas.entity.EstudianteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstudianteMapper {

    EstudianteMapper INSTANCIA = Mappers.getMapper(EstudianteMapper.class);

    EstudianteEntity estudianteDtoToEstudianteEntity(EstudianteDto estudianteDto);

    EstudianteDto estudianteEntityToEstudianteDto(EstudianteEntity estudianteEntity);
}
