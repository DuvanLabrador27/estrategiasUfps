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
import com.ayd.aulas.excepcion.ExcepcionDuplicidad;
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
        ClaseEntity claseEnti = new ClaseEntity(
                0l,
                validarAnio(requestDto.getFecha()),
                existeGrupos(requestDto.getGrupo()),
                existeDocente(requestDto.getDocente()),
                existeMateria(requestDto.getMateria())
        );
        existo(claseEnti);
        ClaseEntity ce = claseDao.save(claseEnti);
        Long id = ce.getId();
        return ClaseResponseDto.builder()
                .clase(id)
                .docente(
                        Objects.nonNull(claseEnti.getDocente()) ?
                                claseEnti.getDocente().getNombre() + " " + claseEnti.getDocente().getApellido() : "Sin Asignar"
                )
                .grupo(claseEnti.getGrupo().getNombre())
                .materia(claseEnti.getMateria().getNombre())
                .periodo(claseEnti.getAnio().getAnio() + "-" + claseEnti.getAnio().getSemestre())
                .build();
    }

    private void existo(ClaseEntity claseEntity) {
        Long materia = claseEntity.getMateria().getId();
        Long grupo = claseEntity.getGrupo().getId();
        Long anio = claseEntity.getAnio().getId();

        boolean existo = claseDao.findByAnioIdAndGrupoIdAndMateriaId(anio, grupo, materia).isPresent();
        if(existo) {
            throw new ExcepcionDuplicidad("La clase " + claseEntity.getGrupo().getNombre() +
                    " de la materia " + claseEntity.getMateria().getNombre() + " ya existe.");
        }
    }

    private MateriaEntity existeMateria(Long id) {
        return materiaDao.findById(id).orElseThrow(
                () -> new ExcepcionSinDatos("La materia no existe")
        );
    }

    private GrupoEntity existeGrupos(Long grupo) {
        return grupoDao.findById(grupo).orElseThrow(
                () -> new ExcepcionSinDatos("El grupo '" + grupo + "' no existe. ")
        );
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
        if (Objects.equals(anioEntity.getId(), 0l)) {
            anioEntity.setId(
                    anioDao.save(anioEntity).getId()
            );
        }
        return anioEntity;
    }
}
