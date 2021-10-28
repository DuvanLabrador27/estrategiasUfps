package com.ayd.aulas.service.clase.impl;

import com.ayd.aulas.convertidores.MateriaDtoToMateriaEntity;
import com.ayd.aulas.dao.ClaseDao;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.entity.intermedias.ClaseEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.clase.AsignarDocenteClaseMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignarDocenteClaseMateriaServiceImpl implements AsignarDocenteClaseMateriaService {

    @Autowired
    private ClaseDao claseDao;

    @Autowired
    private DocenteDao docenteDao;

    @Autowired
    private MateriaDtoToMateriaEntity dtoToAulaEntity;

    @Override
    public void ejecutar(ClaseRequestDto claseD) {
        ClaseEntity claseEntity = existo(claseD.getClase());
        DocenteEntity docenteEntity = validarDocente(claseD.getDocente());
        claseEntity.setDocente(docenteEntity);
        claseDao.save(claseEntity);
    }

    private ClaseEntity existo(Long clase) {
        return claseDao.findById(clase).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontraro la clase")
        );
    }

    private DocenteEntity validarDocente(Long codigo) {
        return docenteDao.findById(codigo).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontraro la clase")
        );
    }
}
