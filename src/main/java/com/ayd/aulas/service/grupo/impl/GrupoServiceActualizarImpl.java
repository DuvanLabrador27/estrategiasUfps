package com.ayd.aulas.service.grupo.impl;

import com.ayd.aulas.convertidores.GrupoResponseDtoToGrupoEntity;
import com.ayd.aulas.convertidores.mappers.GrupoMapper;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.grupo.GrupoServiceActualizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GrupoServiceActualizarImpl implements GrupoServiceActualizar {

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private GrupoResponseDtoToGrupoEntity toGrupoEntity;

    @Override
    public void ejecutar(GrupoResponseDto grupoDto) {
        existo(grupoDto.getId());
        GrupoEntity grupoEntity = toGrupoEntity.responseToEntoty(grupoDto);
        grupoDao.save(grupoEntity);
    }

    private void existo(Long id) {
        GrupoEntity grupoEntity = grupoDao.findById(id).orElse(null);
        if (Objects.isNull(grupoEntity)) {
            throw new ExcepcionSinDatos("No existe el grupo que desea actualizar");
        }
    }
}
