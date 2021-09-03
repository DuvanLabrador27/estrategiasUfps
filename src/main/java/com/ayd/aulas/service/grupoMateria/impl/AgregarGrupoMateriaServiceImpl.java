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
import com.ayd.aulas.service.grupoMateria.AgregarGrupoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AgregarGrupoMateriaServiceImpl implements AgregarGrupoMateriaService {

    @Autowired
    private GrupoMateriaDao grupoMateriaDao;

    @Autowired
    private MateriaDao materiaDao;

    @Autowired
    private GrupoDao grupoDao;


    @Override
    public void ejecutar(MateriaResponseDto responseDto) {
        MateriaEntity materia = existeMateria(responseDto.getId());
        List<GrupoEntity> grupoLista = existenGrupos(responseDto.getGrupos());
        grupoLista.forEach(
                (grupo) -> {
                    GrupoMateriaKey key = new GrupoMateriaKey(grupo.getId(), materia.getId());
                    GrupoMateriaEntity grupoMateriaEntity = new GrupoMateriaEntity(key, grupo, materia);
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
        if (gruposList.isEmpty() || grupos.size() > gruposList.size()) {
            throw  new ExcepcionSinDatos("Uno de los grupos agragados a la Materia no fue encontrado, por favor rectifique.");
        }
        return gruposList;
    }
}
