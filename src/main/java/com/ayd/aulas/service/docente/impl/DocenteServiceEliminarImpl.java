package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteServiceEliminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceEliminarImpl implements DocenteServiceEliminar {

    @Autowired
    private DocenteDao docenteDao;

    @Override
    public void ejectar(Long id) {
        existe(id);
        docenteDao.deleteById(id);
    }

    private void existe(Long id) {
        docenteDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("Docene no existe")
        );
    }
}
