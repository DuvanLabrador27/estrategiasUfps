package com.ayd.aulas.service.clase.impl;

import com.ayd.aulas.convertidores.MateriaDtoToMateriaEntity;
import com.ayd.aulas.dao.ClaseDao;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.entity.AnioEntity;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.entity.intermedias.ClaseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AsignarDocenteClaseMateriaServiceImplTest {

    private MateriaEntity materiaEntity;
    private GrupoEntity grupoEntity;
    private DocenteEntity docenteEntity;
    private AnioEntity anioEntity;
    private ClaseRequestDto requestDto;
    private ClaseEntity claseEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        materiaEntity = new MateriaEntity(1l, LocalDateTime.now(), new ArrayList<ClaseEntity>(), "abc");

        grupoEntity = new GrupoEntity();
        grupoEntity.setId(1l);
        grupoEntity.setNombre("A");

        docenteEntity = new DocenteEntity();
        docenteEntity.setId(1l);
        docenteEntity.setApellido("UNITARIA");
        docenteEntity.setNombre("PRUEBA");

        anioEntity = new AnioEntity();
        anioEntity.setAnio(2021);
        anioEntity.setId(1l);
        anioEntity.setSemestre(1);

        claseEntity = new ClaseEntity();
        claseEntity.setId(1l);
        claseEntity.setAnio(anioEntity);
        claseEntity.setMateria(materiaEntity);
        claseEntity.setDocente(docenteEntity);
        claseEntity.setGrupo(grupoEntity);

        requestDto = new ClaseRequestDto();
        requestDto.setMateria(materiaEntity.getId());
        requestDto.setClase(claseEntity.getId());
        requestDto.setDocente(docenteEntity.getId());
        requestDto.setEstudiante(1l);
        requestDto.setNombre("prueba");
        requestDto.setFecha(LocalDateTime.now());
        requestDto.setGrupo(grupoEntity.getId());


    }
    @Mock
    private ClaseDao claseDao;

    @Mock
    private DocenteDao docenteDao;

    @Mock
    private MateriaDtoToMateriaEntity dtoToAulaEntity;

    @InjectMocks
    private AsignarDocenteClaseMateriaServiceImpl asignarDocenteClaseMateriaService;


    @Test
    void ejecutar() {

    }
}