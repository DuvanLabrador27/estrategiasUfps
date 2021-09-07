package com.ayd.aulas.service.grupoMateriaEstudiante.impl;

import com.ayd.aulas.comun.ValidadoresJpaRepository;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dao.GrupoMateriaEstudianteDao;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.AgregarEstudiantesGrupoMateriaDto;
import com.ayd.aulas.entity.EstudianteEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.GrupoMateriaEstudianteEntity;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.entity.compositeKey.GrupoMateriaEstudianteKey;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.grupoMateriaEstudiante.AgregarEstudiantesGrupoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgregarEstudianteGrupoMateriaServiceImpl implements AgregarEstudiantesGrupoMateriaService {

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private EstudianteDao estudianteDao;

    @Autowired
    private GrupoMateriaEstudianteDao grupoMateriaEstudianteDao;

    @Override
    public void ejecutar(AgregarEstudiantesGrupoMateriaDto dto) {
        MateriaEntity materiaEn = existeMateria(dto.getMateria());
        GrupoEntity grupoEn = existeGrupo(dto.getGrupo());
        List<EstudianteEntity> estudianteEntities = existeEstudiante(dto.getEstudiantes());
        estudianteEntities.forEach(
                estudiante -> {
                    GrupoMateriaEstudianteEntity relacion = new GrupoMateriaEstudianteEntity();
                    GrupoMateriaEstudianteKey id = new GrupoMateriaEstudianteKey(grupoEn.getId(), materiaEn.getId(), estudiante.getId());
                    relacion.setId(id);
                    relacion.setEstudiante(estudiante);
                    relacion.setGrupo(grupoEn);
                    relacion.setMateria(materiaEn);
                    ValidadoresJpaRepository.validarSave(grupoMateriaEstudianteDao, relacion);
                }
        );
    }

    private MateriaEntity existeMateria(Long materiaId) {
        MateriaEntity existe = materiaDao.findById(materiaId).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro la Materia con el id: " + materiaId)
        );
        return existe;
    }

    private List<EstudianteEntity> existeEstudiante(List<Long> estudianteId) {
        List<EstudianteEntity> existe = estudianteDao.findAllById(estudianteId);
        if ((existe.isEmpty() || estudianteId.size() > existe.size()) && !estudianteId.isEmpty()) {
            throw new ExcepcionSinDatos("Uno de los estudiantes agragados al grupo no fue encontrado, por favor rectifique.");
        }
        return existe;
    }

    private GrupoEntity existeGrupo(Long grupoId) {
        GrupoEntity existe = grupoDao.findById(grupoId).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro el grupo con el id: " + grupoId)
        );
        return existe;
    }
}
