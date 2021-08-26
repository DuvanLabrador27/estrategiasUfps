package com.ayd.aulas.service.estudiante.impl;

import com.ayd.aulas.convertidores.EstudianteResponseDtoToEstudianteEntity;
import com.ayd.aulas.convertidores.mappers.EstudianteMapper;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.EstudianteResponseDto;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.estudiante.EstudianteServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EstudianteServiceCrearImpl implements EstudianteServiceCrear {

    @Autowired
    private EstudianteDao estudianteDao;

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private EstudianteResponseDtoToEstudianteEntity dtoToEstudianteEntity;

    @Override
    public Long ejecutar(EstudianteResponseDto estudianteDto) {
        existe(estudianteDto.getNombre());
        EstudianteEntity entity = dtoToEstudianteEntity.responseToEntity(estudianteDto);
        return estudianteDao.save(entity).getId();
    }

    private void existe(String nombre) {
        EstudianteEntity estudianteEntity = estudianteDao.findByNombre(nombre).orElse(null);
        if (Objects.nonNull(estudianteEntity)) {
            throw new ExcepcionDuplicidad("El estudiante ya existe");
        }
    }


}
