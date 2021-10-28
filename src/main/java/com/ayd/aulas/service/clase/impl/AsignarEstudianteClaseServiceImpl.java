package com.ayd.aulas.service.clase.impl;

import com.ayd.aulas.dao.ClaseDao;
import com.ayd.aulas.dao.ClaseEstudianteDao;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.entity.intermedias.ClaseEntity;
import com.ayd.aulas.entity.intermedias.ClaseEstudianteEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.clase.AsignarEstudianteClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignarEstudianteClaseServiceImpl implements AsignarEstudianteClaseService {

    @Autowired
    private ClaseDao claseDao;

    @Autowired
    private EstudianteDao estudianteDao;

    @Autowired
    private ClaseEstudianteDao claseEstudianteDao;

    @Override
    public void ejecutar(ClaseRequestDto claseRequestDto) {
        EstudianteEntity estudianteEn = existeEstudiante(claseRequestDto.getEstudiante());
        ClaseEntity claseEn = exxisteClase(claseRequestDto.getClase());
        ClaseEstudianteEntity entity = new ClaseEstudianteEntity();
        entity.setClase(claseEn);
        entity.setEstudiante(estudianteEn);
        claseEstudianteDao.save(entity);
    }

    private EstudianteEntity existeEstudiante(Long idEstudiante) {
        return estudianteDao.findById(idEstudiante).orElseThrow(
                () -> new ExcepcionSinDatos("EL estudiante no existe en el sistema.")
        );
    }

    private ClaseEntity exxisteClase(Long claseId) {
        return claseDao.findById(claseId).orElseThrow(
                () -> new ExcepcionSinDatos("La clase no existe en el sistema.")
        );
    }
}
