package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.convertidores.MateriaDtoToMateriaEntity;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.MateriaDto;
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
    private MateriaDtoToMateriaEntity materiaDtoToMateriaEntity;

    @Override
    public MateriaDto ejecutar(MateriaDto requestDto) {
        existe(requestDto.getNombre());
        MateriaEntity materiaEntity = materiaDtoToMateriaEntity.dtoResponseToEntity(requestDto);
        materiaEntity = materiaDao.save(materiaEntity);
        return MateriaDto.builder()
                .id(materiaEntity.getId())
                .nombre(materiaEntity.getNombre())
                .build();
    }

    private void existe(String nombre){
       MateriaEntity materiaEntity =  materiaDao.findByNombre(nombre).orElse(null);
       if (Objects.nonNull(materiaEntity)) {
            throw new ExcepcionSinDatos("El aula ya esta creada.");
       }
    }
}
