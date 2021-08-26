package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.convertidores.MateriaResponseDtoToMateriaEntity;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.MateriaResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.materia.MateriaServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServiceModificarImpl implements MateriaServiceModificar {

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private MateriaResponseDtoToMateriaEntity dtoToAulaEntity;

    @Override
    public void ejecutar(MateriaResponseDto aulaDto) {
        existe(aulaDto.getId());
        existeGrupos(aulaDto.getGrupos());
        MateriaEntity materiaEntity = dtoToAulaEntity.dtoResponseToEntity(aulaDto);
        materiaDao.save(materiaEntity);
    }

    private void existe(Long id) {
        materiaDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("El aula a actualizar no existe")
        );
    }

    private void existeGrupos(List<Long> grupoDtos) {
        for (int i = 0; i < grupoDtos.size(); i++) {
            Long dto = grupoDtos.get(i);
            grupoDao.findById(dto).orElseThrow(
                    () -> new ExcepcionSinDatos("El grupo '" + dto + "' no existe")
            );
        }
    }
}
