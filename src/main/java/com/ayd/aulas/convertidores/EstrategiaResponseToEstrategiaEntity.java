package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.EstrategiaResponseDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EstrategiaResponseToEstrategiaEntity {

    @Autowired
    private GrupoDao grupoDao;

    public EstrategiaEntity responseToEntity(EstrategiaResponseDto responseDto) {
        EstrategiaEntity entity = new EstrategiaEntity();

        entity.setCreacion(responseDto.getCreacion());
        entity.setDescripcion(responseDto.getDescripcion());
        entity.setId(responseDto.getId());
        entity.setNombre(responseDto.getNombre());
        responseDto.getGrupos().forEach(
                idGrupo -> {
                    if (idGrupo > 0) {
                        GrupoEntity grupoEntity = grupoDao.findById(idGrupo).orElseThrow(
                                () -> new ExcepcionSinDatos("No se encontro el grupo ´" + idGrupo + "'.")
                        );

                    }
                }
        );
        return entity;
    }
}
