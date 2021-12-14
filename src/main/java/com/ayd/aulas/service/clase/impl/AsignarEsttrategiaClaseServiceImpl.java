package com.ayd.aulas.service.clase.impl;

import com.ayd.aulas.dao.ClaseDao;
import com.ayd.aulas.dao.ClaseEstrategiaDao;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dto.ClaseEstrategiaDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import com.ayd.aulas.entity.intermedias.ClaseEntity;
import com.ayd.aulas.entity.intermedias.ClaseEstrategiaEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
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
        ClaseEntity claseEn = existeClase(estrategiaDto.getClase());
        EstrategiaEntity estrategiaEn = existeEstrategia(estrategiaDto.getEstrategia());
        ClaseEstrategiaEntity entity = new ClaseEstrategiaEntity();

        entity.setId(estrategiaDto.getClase());
        entity.setEstado(estrategiaDto.getEstado());
        entity.setFechaFin(estrategiaDto.getFechaFin());
        entity.setFechaIncio(estrategiaDto.getFechaIncio());
        entity.setClase(claseEn);
        entity.setEstrategia(estrategiaEn);
        boolean existo = claseEstrategiaDao.findByEstrategiaAndClase(
                entity.getEstrategia().getId(),
                entity.getClase().getId()
        ).isPresent();
        if (existo) {
            throw new ExcepcionDuplicidad("La estrategia " + estrategiaEn.getNombre()
                    + " ya esxiste en la clase " + claseEn.getMateria().getNombre() + " - " + claseEn.getGrupo().getNombre() );
        }
        claseEstrategiaDao.save(entity);
    }

    private ClaseEntity existeClase(Long clase) {
        return claseDao.findById(clase).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro la clase")
        );
    }

    private EstrategiaEntity existeEstrategia(Long estrategia) {
        return estrategiaDao.findById(estrategia).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro la estrategia")
        );
    }
}
