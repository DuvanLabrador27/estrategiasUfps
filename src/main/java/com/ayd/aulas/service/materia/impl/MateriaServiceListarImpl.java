package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.convertidores.MateriaEntityToMateriaResponseDto;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.MateriaResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.service.materia.MateriaServiceListar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MateriaServiceListarImpl implements MateriaServiceListar {

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private MateriaEntityToMateriaResponseDto toAulaResponseDto;

    @Override
    public List<MateriaResponseDto> ejecutar() {
        List<MateriaResponseDto> aulaDtos = new ArrayList<>();
        for (MateriaEntity materiaEntity : materiaDao.findAll()) {
            aulaDtos.add(
                    toAulaResponseDto.entityToResponseDto(materiaEntity)
            );
        }
        return aulaDtos;
    }
}
