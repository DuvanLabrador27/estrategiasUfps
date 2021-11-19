package com.ayd.aulas.service.clase.impl;

import com.ayd.aulas.dao.AnioDao;
import com.ayd.aulas.dao.ClaseDao;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.entity.AnioEntity;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.entity.intermedias.ClaseEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AsignarClaseMateriaServiceImplTest {

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
    private MateriaDao materiaDao;

    @Mock
    private GrupoDao grupoDao;

    @Mock
    private DocenteDao docenteDao;

    @Mock
    private AnioDao anioDao;

    @Mock
    private ClaseDao claseDao;

    @InjectMocks
    private AsignarClaseMateriaServiceImpl asignarClaseMateriaService;

    @Test
    void ejecutar() {
        Mockito.when(materiaDao.findById(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(materiaEntity));
        Mockito.when(claseDao.findByAnioIdAndGrupoIdAndMateriaId(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(null));
        Mockito.when(grupoDao.findById(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(grupoEntity));
        Mockito.when(docenteDao.findById(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(docenteEntity));
        Mockito.when(anioDao.findByAnioAndSemestre(Mockito.anyInt(), Mockito.anyInt())).thenReturn(java.util.Optional.ofNullable(anioEntity));
        Mockito.when(claseDao.save(Mockito.any())).thenReturn(claseEntity);
        Assert.assertNotNull(asignarClaseMateriaService.ejecutar(requestDto));
    }
}