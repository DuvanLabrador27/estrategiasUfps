package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteResponseDtoToDocenteEntity;
import com.ayd.aulas.convertidores.mappers.DocenteMapper;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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
