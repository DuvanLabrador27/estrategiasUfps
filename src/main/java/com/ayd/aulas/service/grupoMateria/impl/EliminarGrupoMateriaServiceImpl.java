package com.ayd.aulas.service.grupoMateria.impl;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dao.GrupoMateriaDao;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.MateriaResponseDto;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.GrupoMateriaEntity;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.entity.compositeKey.GrupoMateriaKey;
import com.ayd.aulas.excepcion.ExcepcionSinDatos;
import com.ayd.aulas.service.grupoMateria.EliminarGrupoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EliminarGrupoMateriaServiceImpl implements EliminarGrupoMateriaService {

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private GrupoMateriaDao grupoMateriaDao;


    @Override
    public void ejecutar(MateriaResponseDto responseDto) {
        MateriaEntity materiaEntity = existeMateria(responseDto.getId());
        List<GrupoEntity> grupoEntities = existenGrupos(responseDto.getGrupos());
        List<GrupoMateriaEntity> gruposEliminados = encontrarEliminados(materiaEntity.getGrupoMateriaEntities(), grupoEntities);

        gruposEliminados.forEach(
                elimanado -> grupoMateriaDao.delete(elimanado)
        );

        grupoEntities.forEach(
                (grupo) -> {
                    GrupoMateriaKey key = new GrupoMateriaKey(grupo.getId(), materiaEntity.getId());
                    GrupoMateriaEntity grupoMateriaEntity = new GrupoMateriaEntity(key, grupo, materiaEntity);
                    grupoMateriaDao.save(grupoMateriaEntity);
                }
        );

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

    private List<GrupoMateriaEntity> encontrarEliminados(List<GrupoMateriaEntity> gruposViejos, List<GrupoEntity> gruposNuevos) {
        AtomicReference<List<GrupoMateriaEntity>> listaEliminados = new AtomicReference<>(new ArrayList<>());
        gruposViejos.forEach(
                viejo -> {
                    if (!gruposNuevos.contains(viejo.getGrupo())) {
                        listaEliminados.get().add(viejo);
                    }

                }
        );
        return listaEliminados.get();
    }
}
