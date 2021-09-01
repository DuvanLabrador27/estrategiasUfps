package com.ayd.aulas.convertidores;

import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.EstrategiaEntity;
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
        List<MateriaEntity> materiaEntities = new ArrayList<>();
        entity.setEstrategias(new ArrayList<>());
        if (responseDto.getMaterias().size() > 0) {
            responseDto.getMaterias().stream().map(
                    materia -> materiaEntities.add(
                            materiaDao.findById(materia).orElseThrow(
                                    () -> new ExcepcionSinDatos("No se encontro el aula")
                            )
                    )
            );
            entity.setMaterias(materiaEntities);
        } else {
            entity.setMaterias(null);
        }
        if (responseDto.getDocente() > 0) {
            entity.setDocente(docenteDao.findById(responseDto.getDocente()).orElseThrow(
                    () -> new ExcepcionSinDatos("No se encontro al docente")
            ));
        } else {
            entity.setDocente(null);
        }
        if (responseDto.getEstudiantes() > 0) {
            entity.setEstudiantes(estudianteDao.findById(responseDto.getEstudiantes()).orElseThrow(
                    () -> new ExcepcionSinDatos("No se encontro al estudiante")
            ));
        } else {
            entity.setEstudiantes(null);
        }

        responseDto.getEstrategias().forEach(
                estrategia -> {
                    if (estrategia > 0) {
                        EstrategiaEntity estrategiaEntity = estrategiaDao.findById(estrategia).orElseThrow(
                                () -> new ExcepcionSinDatos("No se encontro la estrategia '" + estrategia + "'.")
                        );
                        entity.getEstrategias().add(estrategiaEntity);
                    }
                }
        );
        entity.setId(responseDto.getId());
        entity.setNombre(responseDto.getNombre());

        return entity;
    }
}
