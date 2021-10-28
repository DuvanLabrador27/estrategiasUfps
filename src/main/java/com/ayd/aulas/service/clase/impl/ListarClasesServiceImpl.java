package com.ayd.aulas.service.clase.impl;

import com.ayd.aulas.dao.ClaseDao;
import com.ayd.aulas.dto.ClaseResponseDto;
import com.ayd.aulas.service.clase.ListarClasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
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
                                .docente(
                                        Objects.nonNull(claseEntity.getDocente()) ?
                                                claseEntity.getDocente().getNombre() + " " + claseEntity.getDocente().getApellido() :
                                                "Sin Asignar"
                                )
                                .grupo(claseEntity.getGrupo().getNombre())
                                .materia(claseEntity.getMateria().getNombre())
                                .periodo(claseEntity.getAnio().getAnio() + " - " + claseEntity.getAnio().getSemestre())
                                .build()
                )
        );
        return claseResponseDtos;
    }
}
