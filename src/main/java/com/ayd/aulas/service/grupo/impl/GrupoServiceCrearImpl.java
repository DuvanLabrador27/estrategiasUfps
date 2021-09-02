package com.ayd.aulas.service.grupo.impl;

import com.ayd.aulas.convertidores.GrupoResponseDtoToGrupoEntity;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.service.grupo.GrupoServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GrupoServiceCrearImpl implements GrupoServiceCrear {

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private GrupoResponseDtoToGrupoEntity toGrupoEntity;

    @Override
    public Long ejecutar(GrupoResponseDto grupoDto) {
        existo(grupoDto.getNombre());
        GrupoEntity grupoEntity = toGrupoEntity.responseToEntoty(grupoDto);
        sincronizarDatos(grupoEntity);
        return grupoDao.save(grupoEntity).getId();
    }

    private void existo(String nombre) {
        GrupoEntity grupoEntity = grupoDao.findByNombre(nombre).orElse(null);
        if (Objects.nonNull(grupoEntity)) {
            throw new ExcepcionDuplicidad("El grupo ´" + nombre + "' ya existe");
        }
    }

    private void sincronizarDatos(GrupoEntity grupoEntity) {
        grupoEntity.getMaterias().forEach(
                materia ->
                        materia.getGrupos().add(grupoEntity)

        );
        grupoEntity.getEstudiantes().forEach(
                estudiante ->
                        estudiante.getGrupos().add(grupoEntity)

        );
        grupoEntity.getEstrategias().forEach(
                estrategia ->
                        estrategia.getGrupos().add(grupoEntity)
        );
    }
}
