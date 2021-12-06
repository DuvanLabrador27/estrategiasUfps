package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.entity.DocenteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DocenteResponseDtoToDocenteEntity {

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public DocenteEntity repsonseDtoToEntity(DocenteResponseDto responseDto) {
        DocenteEntity entity = new DocenteEntity();
        entity.setApellido(responseDto.getApellido());
        entity.setPassword(
                passwordEncoder.encode(responseDto.getContrasena())
        );
        entity.setUsername(responseDto.getCorreo());
        entity.setId(responseDto.getId());
        entity.setNombre(responseDto.getNombre());
        entity.setFechaCreacion(LocalDateTime.now());
        entity.setEnabled(responseDto.isEnabled());
        return entity;
    }
}
