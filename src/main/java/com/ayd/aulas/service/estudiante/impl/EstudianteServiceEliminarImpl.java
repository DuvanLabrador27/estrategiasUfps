package com.ayd.aulas.service.estudiante.impl;

import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
import com.ayd.aulas.service.estudiante.EstudianteServiceEliminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceEliminarImpl implements EstudianteServiceEliminar {

    @Autowired
    private EstudianteDao estudianteDao;

    @Override
    public void ejecutar(Long id) {
        existe(id);
        estudianteDao.deleteById(id);
    }

    private void existe(Long id) {
        EstudianteEntity estudianteEntity = estudianteDao.findById(id).orElseThrow(
                () -> new ExcepcionDuplicidad("El estudiante no existe")
        );
    }
}
