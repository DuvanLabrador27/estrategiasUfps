package com.ayd.aulas.service.aula.impl;

import com.ayd.aulas.dao.AulaDao;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.aula.AulaServiceEliminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaServiceEliminarImpl implements AulaServiceEliminar {

    @Autowired
    private AulaDao aulaDao;

    @Override
    public void ejecutar(Long id) {
        existe(id);
        aulaDao.deleteById(id);
    }

    private void existe(Long id) {
        aulaDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("El aula a eliminar no existe.")
        );
    }
}
