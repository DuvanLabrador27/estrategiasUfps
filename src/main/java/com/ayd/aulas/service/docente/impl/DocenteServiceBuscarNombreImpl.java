package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteEntityToDocenteResponseDto;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteServiceBuscarNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceBuscarNombreImpl implements DocenteServiceBuscarNombre {

    @Autowired
    private DocenteDao docenteDao;

    @Autowired
    private DocenteEntityToDocenteResponseDto toDocenteResponseDto;

    @Override
    public DocenteResponseDto ejecutar(String nombre) {
        DocenteEntity docenteEntity = docenteDao.findByNombre(nombre).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro al estudiante '" + nombre + "'.")
        );
        DocenteResponseDto response = toDocenteResponseDto.entityToResponseDto(docenteEntity);
        return response;
    }
}
