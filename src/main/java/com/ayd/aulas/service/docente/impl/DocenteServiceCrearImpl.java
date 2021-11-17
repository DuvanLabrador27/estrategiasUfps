package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteResponseDtoToDocenteEntity;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.service.docente.DocenteServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DocenteServiceCrearImpl implements DocenteServiceCrear {

    @Autowired
    private DocenteDao docenteDao;

    @Autowired
    private DocenteResponseDtoToDocenteEntity toDocenteEntity;

    @Override
    public Long ejecutar(DocenteResponseDto docenteDto) {
        existe(docenteDto.getNombre());
        DocenteEntity aulaEntity = toDocenteEntity.repsonseDtoToEntity(docenteDto);
        return docenteDao.save(aulaEntity).getId();
    }

    private void existe(String nombre) {
        DocenteEntity docenteEntity = docenteDao.findByNombre(nombre).orElse(null);
        if (Objects.nonNull(docenteEntity)) {
            throw new ExcepcionDuplicidad("El docente ya existe");
        }
    }
}
