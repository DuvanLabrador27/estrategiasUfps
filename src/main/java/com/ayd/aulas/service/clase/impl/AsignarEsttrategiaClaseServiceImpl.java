package com.ayd.aulas.service.clase.impl;

import com.ayd.aulas.dao.ClaseDao;
import com.ayd.aulas.dao.ClaseEstrategiaDao;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dto.ClaseEstrategiaDto;
import com.ayd.aulas.entity.intermedias.ClaseEstrategiaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.clase.AsignarEstrategiaClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignarEsttrategiaClaseServiceImpl implements AsignarEstrategiaClaseService {

    @Autowired
    private ClaseEstrategiaDao claseEstrategiaDao;

    @Autowired
    private ClaseDao claseDao;

    @Autowired
    private EstrategiaDao estrategiaDao;

    @Override
    public void ejecutar(ClaseEstrategiaDto estrategiaDto) {
        existeClase(estrategiaDto.getClase());
        existeEstrategia(estrategiaDto.getEstrategia());
        ClaseEstrategiaEntity entity = new ClaseEstrategiaEntity();
        entity.setId(estrategiaDto.getClase());
        entity.setEstado(estrategiaDto.getEstado());
        entity.setFechaFin(estrategiaDto.getFechaFin());
        entity.setFechaIncio(estrategiaDto.getFechaIncio());
        claseEstrategiaDao.save(entity);
    }

    private void existeClase(Long clase) {
        claseDao.findById(clase).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro la clase")
        );
    }

    private void existeEstrategia(Long estrategia) {
        estrategiaDao.findById(estrategia).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro la estrategia")
        );
    }
}
