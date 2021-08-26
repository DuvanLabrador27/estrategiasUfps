package com.ayd.aulas.service.estudiante.impl;

import com.ayd.aulas.convertidores.EstudianteEntityToEstudianteResponseDto;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dto.EstudianteResponseDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.service.estudiante.EstudianteServiceListar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteServiceListarImpl implements EstudianteServiceListar {

    @Autowired
    private EstudianteDao estudianteDao;

    @Autowired
    private EstudianteEntityToEstudianteResponseDto toEstudianteResponseDto;

    @Override
    public List<EstudianteResponseDto> ejecutar() {
        List<EstudianteResponseDto> list = new ArrayList<>();
        for (EstudianteEntity entity : estudianteDao.findAll()) {
            list.add(
                    toEstudianteResponseDto.entityToResponseDto(entity)
            );
        }
        return list;
    }
}
