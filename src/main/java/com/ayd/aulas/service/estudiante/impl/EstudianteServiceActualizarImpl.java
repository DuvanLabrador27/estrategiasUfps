package com.ayd.aulas.service.estudiante.impl;

import com.ayd.aulas.convertidores.EstudianteResponseDtoToEstudianteEntity;
import com.ayd.aulas.convertidores.mappers.EstudianteMapper;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.EstudianteDto;
import com.ayd.aulas.dto.EstudianteResponseDto;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.estudiante.EstudianteServiceActualizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EstudianteServiceActualizarImpl implements EstudianteServiceActualizar {

    @Autowired
    private EstudianteDao estudianteDao;

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private EstudianteResponseDtoToEstudianteEntity dtoToEstudianteEntity;

    @Override
    public void ejecutar(EstudianteResponseDto estudianteDto) {
        existe(estudianteDto.getId());
        EstudianteEntity entity = dtoToEstudianteEntity.responseToEntity(estudianteDto);
        estudianteDao.save(entity);
    }

    private void existe(Long id){
        EstudianteEntity estudianteEntity = estudianteDao.findById(id).orElse(null);
        if (Objects.isNull(estudianteEntity)) {
            throw new ExcepcionDuplicidad("El estudiante no existe");
        }
    }
}
