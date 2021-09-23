package com.ayd.aulas.service.clase.impl;

import com.ayd.aulas.dao.AnioDao;
import com.ayd.aulas.dao.ClaseDao;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.dto.ClaseResponseDto;
import com.ayd.aulas.entity.AnioEntity;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.entity.intermedias.ClaseEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.clase.AsignarClaseMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class AsignarClaseMateriaServiceImpl implements AsignarClaseMateriaService {

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private DocenteDao docenteDao;

    @Autowired
    private AnioDao anioDao;

    @Autowired
    private ClaseDao claseDao;

    @Override
    public ClaseResponseDto ejecutar(ClaseRequestDto requestDto) {
        ClaseEntity anioGrupo = new ClaseEntity(
                0l,
                validarAnio(requestDto.getFecha()),
                existeGrupos(requestDto.getGrupo()),
                existeDocente(requestDto.getDocente()),
                existeMateria(requestDto.getMateria())
        );
        Long id = claseDao.save(anioGrupo).getId();
        return ClaseResponseDto.builder()
                .clase(id)
                .docente(anioGrupo.getDocente().getNombre() + " " + anioGrupo.getDocente().getApellido())
                .grupo(anioGrupo.getGrupo().getNombre())
                .materia(anioGrupo.getMateria().getNombre())
                .periodo(anioGrupo.getAnio().getAnio() + "-" + anioGrupo.getAnio().getSemestre())
                .build();
    }

    private MateriaEntity existeMateria(Long id) {
        MateriaEntity materia = materiaDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("La materia no existe")
        );
        return materia;
    }

    private GrupoEntity existeGrupos(Long grupo) {
        GrupoEntity grupoEn = grupoDao.findById(grupo).orElseThrow(
                () -> new ExcepcionSinDatos("El grupo '" + grupo + "' no existe. ")
        );
        return grupoEn;
    }

    private DocenteEntity existeDocente(Long idDocente) {
        DocenteEntity docente = null;
        if (Objects.nonNull(idDocente) && idDocente > 0) {
            docente = docenteDao.findById(idDocente).orElseThrow(
                    () -> new ExcepcionSinDatos("El docente '" + idDocente + "' no existe. ")
            );
        }
        return docente;
    }

    private AnioEntity validarAnio(LocalDateTime fecha) {
        Integer year = fecha.getYear();
        Integer semestre = fecha.getMonthValue() <= 6 ? 1 : 2;
        AnioEntity anioEntity = anioDao.findByAnioAndSemestre(year, semestre).orElse(
                new AnioEntity(0l, null, year, semestre)
        );
        if (Objects.equals(anioEntity.getId(), 0)) {
            anioEntity.setId(
                    anioDao.save(anioEntity).getId()
            );
        }
        return anioEntity;
    }
}
