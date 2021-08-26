package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.convertidores.AulaResponseDtoToAulaEntity;
import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.AulaResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.aula.AulaServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceModificarImpl implements AulaServiceModificar {

    @Autowired
    private AulaDao aulaDao;

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private AulaResponseDtoToAulaEntity dtoToAulaEntity;

    @Override
    public void ejecutar(AulaResponseDto aulaDto) {
        existe(aulaDto.getId());
        existeGrupos(aulaDto.getGrupos());
        MateriaEntity materiaEntity = dtoToAulaEntity.dtoResponseToEntity(aulaDto);
        aulaDao.save(materiaEntity);
    }

    private void existe(Long id) {
        aulaDao.findById(id).orElseThrow(
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
