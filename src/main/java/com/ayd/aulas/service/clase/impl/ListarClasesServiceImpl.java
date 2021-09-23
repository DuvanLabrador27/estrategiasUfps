package com.ayd.aulas.service.clase.impl;

import com.ayd.aulas.dao.ClaseDao;
import com.ayd.aulas.dto.ClaseResponseDto;
import com.ayd.aulas.service.clase.ListarClasesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ListarClasesServiceImpl implements ListarClasesService {

    @Autowired
    private ClaseDao claseDao;

    @Override
    public List<ClaseResponseDto> ejecutar() {
        List<ClaseResponseDto> claseResponseDtos = new ArrayList<>();
        claseDao.findAll().forEach(
                claseEntity -> claseResponseDtos.add(
                        ClaseResponseDto.builder()
                                .clase(claseEntity.getId())
                                .docente(claseEntity.getDocente().getNombre() + " " + claseEntity.getDocente().getApellido())
                                .grupo(claseEntity.getGrupo().getNombre())
                                .materia(claseEntity.getMateria().getNombre())
                                .build()
                )
        );
        return claseResponseDtos;
    }
}
