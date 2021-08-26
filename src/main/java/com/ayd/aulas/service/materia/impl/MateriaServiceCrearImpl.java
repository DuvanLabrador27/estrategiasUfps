package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.convertidores.MateriaResponseDtoToMateriaEntity;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.MateriaResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.materia.MateriaServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MateriaServiceCrearImpl implements MateriaServiceCrear {

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private MateriaResponseDtoToMateriaEntity materiaResponseDtoToMateriaEntity;

    @Override
    public Long ejecutar(MateriaResponseDto aulaDto) {
        existe(aulaDto.getNombre());
        MateriaEntity materiaEntity = materiaResponseDtoToMateriaEntity.dtoResponseToEntity(aulaDto);
        return materiaDao.save(materiaEntity).getId();
    }

    private void existe(String nombre){
       MateriaEntity materiaEntity =  materiaDao.findByNombre(nombre).orElse(null);
       if (Objects.nonNull(materiaEntity)) {
            throw new ExcepcionSinDatos("El aula ya esta creada.");
       }
    }
}
