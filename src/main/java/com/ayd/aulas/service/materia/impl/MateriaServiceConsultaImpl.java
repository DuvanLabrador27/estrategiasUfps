package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.convertidores.MateriaEntityToMateriaResponseDto;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.MateriaResponseDto;
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
    private MateriaEntityToMateriaResponseDto toAulaResponseDto;

    public MateriaResponseDto ejecutar(String nombre) {
        MateriaEntity materiaEntity = materiaDao.findByNombre(nombre).orElseThrow(
                () -> new ExcepcionSinDatos("El aula" + nombre + "no existe")
        );
        return toAulaResponseDto.entityToResponseDto(materiaEntity);
    }
}
