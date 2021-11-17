package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.MateriaDto;
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

    @Override
    public List<MateriaDto> ejecutar() {
        List<MateriaEntity> materias = materiaDao.findAll();
        List<MateriaDto> responseDtoList = new ArrayList<>();
        materias.forEach(
                materiaEn -> responseDtoList.add(
                        MateriaDto.builder()
                                .id(materiaEn.getId())
                                .nombre(materiaEn.getNombre())
                                .build()
                )
        );
        return responseDtoList;
    }
}
