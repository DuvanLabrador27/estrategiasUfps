package com.ayd.aulas.service.grupoMateriaEstudiante.impl;

import com.ayd.aulas.comun.ValidadoresJpaRepository;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dao.GrupoMateriaEstrategiaDao;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.AgregarEstrategiaGrupoMateriaDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.GrupoMateriaEstrategiaEntity;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.grupoMateriaEstudiante.AgregarEstrategiaGrupoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;

import static com.ayd.aulas.comun.ValidadoresJpaRepository.validarSave;

import java.util.List;

public class AgregarEstrategiaGrupoMateriaServiceImpl implements AgregarEstrategiaGrupoMateriaService {

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private GrupoMateriaEstrategiaDao grupoMateriaEstrategiaDao;

    @Autowired
    private EstrategiaDao estrategiaDao;

    @Override
    public void ejecutar(AgregarEstrategiaGrupoMateriaDto dto) {
        MateriaEntity materiaEntity = existeMateria(dto.getMateria());
        GrupoEntity grupoEntity = existeGrupo(dto.getGrupo());
        existeEstrategia(dto.getEstrategias()).forEach(
                estrategia -> {
                    GrupoMateriaEstrategiaEntity relacion = new GrupoMateriaEstrategiaEntity();
                    relacion.setEstrategia(estrategia);
                    relacion.setGrupo(grupoEntity);
                    relacion.setMateria(materiaEntity);
                    ValidadoresJpaRepository.validarSave(grupoMateriaEstrategiaDao, relacion);
                }
        );
    }

    private MateriaEntity existeMateria(Long materiaId) {
        MateriaEntity existe = materiaDao.findById(materiaId).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro la Materia con el id: " + materiaId)
        );
        return existe;
    }

    private List<EstrategiaEntity> existeEstrategia(List<Long> estudianteId) {
        List<EstrategiaEntity> existe = estrategiaDao.findAllById(estudianteId);
        if ((existe.isEmpty() || estudianteId.size() > existe.size()) && !estudianteId.isEmpty()) {
            throw new ExcepcionSinDatos("Uno de las estrategias agragados al grupo no fue encontrada, por favor rectifique.");
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
