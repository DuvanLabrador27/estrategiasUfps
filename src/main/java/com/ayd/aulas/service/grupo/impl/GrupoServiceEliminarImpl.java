package com.ayd.aulas.service.grupo.impl;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.grupo.GrupoServiceEliminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GrupoServiceEliminarImpl implements GrupoServiceEliminar {

    @Autowired
    private GrupoDao grupoDao;

    @Override
    public void ejecutar(Long id) {
        existo(id);
        grupoDao.deleteById(id);
    }

    private void existo(Long id) {
        GrupoEntity grupoEntity = grupoDao.findById(id).orElse(null);
        if (Objects.isNull(grupoEntity)) {
            throw new ExcepcionSinDatos("No existe el grupo que desea eliminar");
        }
    }
}
