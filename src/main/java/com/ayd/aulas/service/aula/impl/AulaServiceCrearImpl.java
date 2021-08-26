package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.convertidores.AulaResponseDtoToAulaEntity;
import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.dto.AulaResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.aula.AulaServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AulaServiceCrearImpl implements AulaServiceCrear {

    @Autowired
    private AulaDao aulaDao;

    @Autowired
    private AulaResponseDtoToAulaEntity aulaResponseDtoToAulaEntity;

    @Override
    public Long ejecutar(AulaResponseDto aulaDto) {
        existe(aulaDto.getNombre());
        MateriaEntity materiaEntity = aulaResponseDtoToAulaEntity.dtoResponseToEntity(aulaDto);
        return aulaDao.save(materiaEntity).getId();
    }

    private void existe(String nombre){
       MateriaEntity materiaEntity =  aulaDao.findByNombre(nombre).orElse(null);
       if (Objects.nonNull(materiaEntity)) {
            throw new ExcepcionSinDatos("El aula ya esta creada.");
       }
    }
}
