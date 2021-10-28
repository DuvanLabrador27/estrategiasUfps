package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.dto.ClaseResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.materia.MateriaServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MateriaServiceModificarImpl implements MateriaServiceModificar {

    @Autowired
    private MateriaDao materiaDao;

    @Override
    public ClaseResponseDto ejecutar(ClaseRequestDto requestDto) {
        MateriaEntity materia = existeMateria(requestDto.getMateria());
        if (!Objects.equals(requestDto.getNombre(), materia.getNombre())){
            materia.setNombre(requestDto.getNombre());
            materiaDao.save(materia);
        }
        return ClaseResponseDto.builder()
                .materia(materia.getNombre())
                .build();
    }

    private MateriaEntity existeMateria(Long id) {
        MateriaEntity materia = null;
        if (Objects.nonNull(id)) {
            materia = materiaDao.findById(id).orElseThrow(
                    () -> new ExcepcionSinDatos("La materia no existe")
            );
        }
        return materia;
    }

}
