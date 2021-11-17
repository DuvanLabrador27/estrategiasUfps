package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.MateriaDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.entity.intermedias.ClaseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MateriaServiceListarImplTest {

    private MateriaDto materiaDto;
    private MateriaEntity materiaEntity;
    private ArrayList<MateriaEntity> materiaEntities;
    private ArrayList<MateriaDto> materiaEntitiesDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        materiaDto = new MateriaDto(1l, "abc");
        materiaEntity = new MateriaEntity(1l, LocalDateTime.now(), new ArrayList<ClaseEntity>(), "abc");
        materiaEntities = new ArrayList<>();
        materiaEntitiesDto = new ArrayList<>();
        materiaEntitiesDto.add(materiaDto);
        materiaEntities.add(materiaEntity);
    }

    @Mock
    private MateriaDao materiaDao;

    @InjectMocks
    private MateriaServiceListarImpl materiaServiceListar;

    @Test
    void ejecutar() {
        Mockito.when(materiaDao.findAll()).thenReturn(materiaEntities);
        assertArrayEquals(materiaServiceListar.ejecutar().toArray(), materiaEntitiesDto.toArray());
    }
}