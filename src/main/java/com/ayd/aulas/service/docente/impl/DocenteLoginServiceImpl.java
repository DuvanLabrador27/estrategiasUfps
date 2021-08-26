package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.docente.DocenteLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DocenteLoginServiceImpl implements DocenteLoginService {

    @Autowired
    private DocenteDao docenteDao;

    @Override
    public boolean ejecutar(DocenteResponseDto responseDto) {
        String pss = exito(responseDto.getCorreo());
        if (Objects.equals(responseDto.getContrasena(), pss)) {
            return true;
        }
        return false;
    }

    private String exito(String correo) {
        DocenteEntity docenteEntity = docenteDao.findByCorreo(correo).orElse(null);
        if (Objects.isNull(docenteEntity)) {
            throw new ExcepcionSinDatos("El docente no existe");
        }
        return docenteEntity.getContrasena();
    }
}
