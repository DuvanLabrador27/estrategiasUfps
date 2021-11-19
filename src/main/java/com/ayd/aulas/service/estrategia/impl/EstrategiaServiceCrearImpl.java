package com.ayd.aulas.service.estrategia.impl;

import com.ayd.aulas.convertidores.EstrategiaResponseToEstrategiaEntity;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dto.EstrategiaResponseDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.service.estrategia.EstrategiaServiceCrear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EstrategiaServiceCrearImpl implements EstrategiaServiceCrear {

    @Autowired
    private EstrategiaDao estrategiaDao;

    @Autowired
    private EstrategiaResponseToEstrategiaEntity toEstrategiaEntity;

    @Override
    public Long ejecutar(EstrategiaResponseDto estrategiaDto) {
        existe(estrategiaDto.getNombre());
        EstrategiaEntity estrategiaEntity = toEstrategiaEntity.responseToEntity(estrategiaDto);
        return estrategiaDao.save(estrategiaEntity).getId();
    }

    private void existe(String nombre) {
        EstrategiaEntity existo = estrategiaDao.findByNombre(nombre).orElse(null);
        if (Objects.nonNull(existo)) {
            throw new ExcepcionDuplicidad("Estrategia '" + nombre + "' ya esxiste.");
        }
    }
}
