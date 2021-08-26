package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteEntityToDocenteResponseDto;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.service.docente.DocenteServiceListar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteServiceListarImpl implements DocenteServiceListar {

    @Autowired
    private DocenteDao docenteDao;

    @Autowired
    private DocenteEntityToDocenteResponseDto toDocenteResponseDto;

    @Override
    public List<DocenteResponseDto> ejecutar() {
        List<DocenteResponseDto> list = new ArrayList<>();
        for (DocenteEntity docenteEntity : docenteDao.findAll()) {
            list.add(
                    toDocenteResponseDto.entityToResponseDto(docenteEntity)
            );
        }
        return list;
    }
}
