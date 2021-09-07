package com.ayd.aulas.service.grupoMateriaEstudiante.impl;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dao.GrupoMateriaEstudianteDao;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.MateriaResponseDto;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.GrupoMateriaEstudianteEntity;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.grupoMateriaEstudiante.ActualizarGrupoMateriaEstrategiaEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualizarGrupoMateriaEstrategiaEstudianteServiceImpl implements ActualizarGrupoMateriaEstrategiaEstudianteService {

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private GrupoMateriaEstudianteDao grupoMateriaEstudianteDao;


    @Override
    public void ejecutar(MateriaResponseDto responseDto) {
        MateriaEntity materiaEntity = existeMateria(responseDto.getId());
        List<GrupoEntity> grupoEntities = existenGrupos(responseDto.getGrupos());
        encontrarEliminados(materiaEntity.getGrupoMateriaEstudiante(), grupoEntities);
//        actualizarMateria(grupoEntities, materiaEntity);
    }

    private MateriaEntity existeMateria(Long materiaId) {
        MateriaEntity existe = materiaDao.findById(materiaId).orElseThrow(
                () -> new ExcepcionSinDatos("No se encontro la Materia con el id: " + materiaId)
        );
        return existe;
    }

    private List<GrupoEntity> existenGrupos(List<Long> grupos) {
        List<GrupoEntity> gruposList = grupoDao.findAllById(grupos);
        if ((gruposList.isEmpty() || grupos.size() > gruposList.size()) && !grupos.isEmpty()) {
            throw new ExcepcionSinDatos("Uno de los grupos agragados a la Materia no fue encontrado, por favor rectifique.");
        }
        return gruposList;
    }

    private void encontrarEliminados(List<GrupoMateriaEstudianteEntity> gruposViejos, List<GrupoEntity> gruposNuevos) {
        gruposViejos.forEach(
                viejo -> {
                    if (!gruposNuevos.contains(viejo.getGrupo())) {
                        grupoMateriaEstudianteDao.delete(viejo);
                    }
                }
        );
    }

//    private void actualizarMateria(List<GrupoEntity> grupoEntities, MateriaEntity materiaEntity) {
//        grupoEntities.forEach(
//                (grupo) -> {
//                    GrupoMateriaEstrategiaEstudianteKey key = new GrupoMateriaEstrategiaEstudianteKey(grupo.getId(), materiaEntity.getId());
//                    GrupoMateriaEstrategiaEstudianteEntity grupoMateriaEstrategiaEstudianteEntity = new GrupoMateriaEstrategiaEstudianteEntity(key, grupo, materiaEntity);
//                    grupoMateriaEstrategiaEstudianteDao.save(grupoMateriaEstrategiaEstudianteEntity);
//                }
//        );
//    }
}
