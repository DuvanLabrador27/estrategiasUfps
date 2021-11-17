package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.EstudianteResponseDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstudianteResponseDtoToEstudianteEntity {

    @Autowired
    private GrupoDao grupoDao;

    public EstudianteEntity responseToEntity(EstudianteResponseDto responseDto) {
        EstudianteEntity entity = new EstudianteEntity();
        entity.setApellido(responseDto.getApellido());
        entity.setContrasena(responseDto.getContrasena());
        entity.setCorreo(responseDto.getCorreo());
        entity.setId(responseDto.getId());
        entity.setNombre(responseDto.getNombre());
        entity.setRepitente(responseDto.isRepitente());
        responseDto.getGrupos().forEach(grupo -> {
            if (grupo > 0) {
                grupoDao.findById(grupo)
                        .orElseThrow(() -> new ExcepcionSinDatos("No encontramos el grupo '" + grupo + "'."));

            }
        });
        return entity;
    }
}
