package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.entity.DocenteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DocenteEntityToDocenteResponseDto {

    public DocenteResponseDto entityToResponseDto(DocenteEntity entity) {
        DocenteResponseDto responseDto = new DocenteResponseDto();
        responseDto.setGrupos(new ArrayList<>());
        responseDto.setId(entity.getId());
        responseDto.setApellido(entity.getApellido());
        responseDto.setNombre(entity.getNombre());
        responseDto.setContrasena(entity.getPassword());
        responseDto.setCorreo(entity.getCorreo());
        return responseDto;
    }
}
