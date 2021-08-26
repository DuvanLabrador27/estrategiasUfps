package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.EstudianteResponseDto;
import com.ayd.aulas.entity.EstudianteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EstudianteEntityToEstudianteResponseDto {

    public EstudianteResponseDto entityToResponseDto(EstudianteEntity estudianteEntity) {

        EstudianteResponseDto responseDto = new EstudianteResponseDto();
        responseDto.setApellido(estudianteEntity.getApellido());
        responseDto.setContrasena(estudianteEntity.getContrasena());
        responseDto.setCorreo(estudianteEntity.getCorreo());
        responseDto.setId(estudianteEntity.getId());
        responseDto.setNombre(estudianteEntity.getNombre());
        responseDto.setRepitente(estudianteEntity.isRepitente());
        responseDto.setGrupos(new ArrayList<>());
        estudianteEntity.getGrupos().forEach(
                grupo -> responseDto.getGrupos().add(grupo.getId())
        );

        return responseDto;
    }
}
