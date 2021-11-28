package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.entity.DocenteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DocenteResponseDtoToDocenteEntity {

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public DocenteEntity repsonseDtoToEntity(DocenteResponseDto responseDto) {
        DocenteEntity entity = new DocenteEntity();
        entity.setApellido(responseDto.getApellido());
        entity.setPassword(
                bCryptPasswordEncoder.encode(
                        responseDto.getContrasena()
                )
        );
        entity.setCorreo(responseDto.getCorreo());
        entity.setId(responseDto.getId());
        entity.setNombre(responseDto.getNombre());

        return entity;
    }
}
