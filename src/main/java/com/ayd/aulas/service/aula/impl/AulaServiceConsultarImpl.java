package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.convertidores.AulaEntityToAulaResponseDto;
import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.dto.AulaResponseDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.aula.AulaServiceConsultar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaServiceConsultarImpl implements AulaServiceConsultar {

    @Autowired
    private AulaDao aulaDao;

    @Autowired
    private AulaEntityToAulaResponseDto toAulaResponseDto;

    public AulaResponseDto ejecutar(String nombre) {
        MateriaEntity materiaEntity = aulaDao.findByNombre(nombre).orElseThrow(
                () -> new ExcepcionSinDatos("El aula" + nombre + "no existe")
        );
        return toAulaResponseDto.entityToResponseDto(materiaEntity);
    }
}
