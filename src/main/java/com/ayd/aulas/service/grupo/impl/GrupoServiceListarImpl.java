package com.ayd.aulas.service.grupo.impl;

import com.ayd.aulas.convertidores.GrupoEntityToGrupoResponseDto;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.service.grupo.GrupoServiceListar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GrupoServiceListarImpl implements GrupoServiceListar {

    @Autowired
    private GrupoDao grupoDao;


    @Override
    public List<GrupoResponseDto> ejecutar() {
        List<GrupoResponseDto> grupoDtos = new ArrayList<>();
        for (GrupoEntity grupoEntity : grupoDao.findAll()) {
            grupoDtos.add(
                    GrupoEntityToGrupoResponseDto.entityToDto(grupoEntity)
            );
        }
        return grupoDtos;
    }
}
