package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteEntityToDocenteResponseDto;
import com.ayd.aulas.convertidores.DocenteResponseDtoToDocenteEntity;
import com.ayd.aulas.convertidores.mappers.DocenteMapper;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServiceModificarImpl implements DocenteServiceModificar {

    @Autowired
    private DocenteDao docenteDao;

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private DocenteResponseDtoToDocenteEntity toDocenteEntity;

    @Override
    public void ejecutar(DocenteResponseDto docenteDto) {
        existe(docenteDto.getId());
        DocenteEntity docenteEntity = toDocenteEntity.repsonseDtoToEntity(docenteDto);
        docenteDao.save(docenteEntity);
    }

    private void existe(Long id) {
        docenteDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("no existe el docente")
        );
    }


    
}
