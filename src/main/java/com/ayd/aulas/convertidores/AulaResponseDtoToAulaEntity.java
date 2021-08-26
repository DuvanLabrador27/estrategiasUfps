package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.AulaResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AulaResponseDtoToAulaEntity {

    @Autowired
    private GrupoDao grupoDao;

    public MateriaEntity dtoResponseToEntity(AulaResponseDto dto) {
        MateriaEntity entity = new MateriaEntity();
        entity.setGrupos(new ArrayList<>());
        entity.setGrupos(new ArrayList<>());
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        dto.getGrupos().forEach(
                idGrupo -> {
                    if (idGrupo > 0) {
                        GrupoEntity entityG = this.grupoDao.findById(idGrupo).orElseThrow(
                                () -> new ExcepcionSinDatos("EL grupo '" + idGrupo + "' no existe.")
                        );
                        entity.getGrupos().add(entityG);
                    }
                }
        );
        return entity;
    }
}
