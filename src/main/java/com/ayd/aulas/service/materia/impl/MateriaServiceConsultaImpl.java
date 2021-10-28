package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.convertidores.MateriaEntityToMateriaDto;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.MateriaDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.materia.MateriaServiceConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceConsultaImpl implements MateriaServiceConsulta {

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private MateriaEntityToMateriaDto toAulaResponseDto;

    public MateriaDto ejecutar(String nombre) {
        MateriaEntity materiaEntity = materiaDao.findByNombre(nombre).orElseThrow(
                () -> new ExcepcionSinDatos("El aula" + nombre + "no existe")
        );
        return MateriaDto.builder()
                .id(materiaEntity.getId())
                .nombre(materiaEntity.getNombre())
                .build();
    }
}
