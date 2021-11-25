package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DocenteResponseDtoToDocenteEntity {

    @Autowired
    private GrupoDao grupoDao;

    public DocenteEntity repsonseDtoToEntity(DocenteResponseDto responseDto) {
        DocenteEntity entity = new DocenteEntity();
        entity.setApellido(responseDto.getApellido());
        entity.setPassword(responseDto.getContrasena());
        entity.setCorreo(responseDto.getCorreo());
        entity.setId(responseDto.getId());
        entity.setNombre(responseDto.getNombre());

        return entity;
    }
}
