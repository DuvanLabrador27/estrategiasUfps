package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GrupoResponseDtoToGrupoEntity {

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private DocenteDao docenteDao;

    @Autowired
    private EstrategiaDao estrategiaDao;

    @Autowired
    private EstudianteDao estudianteDao;

    public GrupoEntity responseToEntoty(GrupoResponseDto responseDto) {
        GrupoEntity entity = new GrupoEntity();
        entity.setId(responseDto.getId());
        entity.setNombre(responseDto.getNombre());

        return entity;
    }
}
