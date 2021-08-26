package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.materia.MateriaServiceEliminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceEliminarImpl implements MateriaServiceEliminar {

    @Autowired
    private MateriaDao materiaDao;

    @Override
    public void ejecutar(Long id) {
        existe(id);
        materiaDao.deleteById(id);
    }

    private void existe(Long id) {
        materiaDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("El aula a eliminar no existe.")
        );
    }
}
