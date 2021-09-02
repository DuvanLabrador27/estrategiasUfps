package com.ayd.aulas.service.grupo.impl;

import com.ayd.aulas.convertidores.GrupoResponseDtoToGrupoEntity;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.grupo.GrupoServiceActualizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        sincronizarDatos(grupoEntity);
        grupoDao.save(grupoEntity);
    }

    private void existo(Long id) {
        GrupoEntity grupoEntity = grupoDao.findById(id).orElse(null);
        if (Objects.isNull(grupoEntity)) {
            throw new ExcepcionSinDatos("No existe el grupo que desea actualizar");
        }
    }

    private void sincronizarDatos(GrupoEntity grupoEntity) {
        grupoEntity.getMaterias().forEach(
                materia -> {
                    if (materia.getGrupos().size() > 0) {
                        List<GrupoEntity> aux = new ArrayList<>(materia.getGrupos());
                        materia.getGrupos().clear();
                        aux.forEach(
                                au -> {
                                    if (au.getId() != grupoEntity.getId()) {
                                        materia.getGrupos().add(au);
                                    }
                                    materia.getGrupos().add(grupoEntity);
                                }
                        );
                    } else {
                        materia.getGrupos().add(grupoEntity);
                    }
                }
        );
        grupoEntity.getEstudiantes().forEach(
                estudiante -> {
                    if (estudiante.getGrupos().size() > 0) {
                        List<GrupoEntity> aux = new ArrayList<>(estudiante.getGrupos());
                        estudiante.getGrupos().clear();
                        aux.forEach(
                                au -> {
                                    if (au.getId() != grupoEntity.getId()) {
                                        estudiante.getGrupos().add(au);
                                    }
                                    estudiante.getGrupos().add(grupoEntity);
                                }
                        );
                    }else {
                        estudiante.getGrupos().add(grupoEntity);
                    }
                }

        );
        grupoEntity.getEstrategias().forEach(
                estrategia -> {
                    if (estrategia.getGrupos().size() > 0) {
                        List<GrupoEntity> aux = new ArrayList<>(estrategia.getGrupos());
                        estrategia.getGrupos().clear();
                        aux.forEach(
                                au -> {
                                    if (au.getId() != grupoEntity.getId()) {
                                        estrategia.getGrupos().add(au);
                                    }
                                    estrategia.getGrupos().add(grupoEntity);
                                }
                        );
                    }else {
                        estrategia.getGrupos().add(grupoEntity);
                    }
                }
        );
    }
}
