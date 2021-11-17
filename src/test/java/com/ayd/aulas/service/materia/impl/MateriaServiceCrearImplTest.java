package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.convertidores.MateriaDtoToMateriaEntity;
import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.MateriaDto;
import com.ayd.aulas.entity.MateriaEntity;
import com.ayd.aulas.entity.intermedias.ClaseEntity;
import com.mysql.cj.result.LocalDateTimeValueFactory;
import org.hibernate.type.LocalDateTimeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MateriaServiceCrearImplTest {

    @Mock
    private MateriaDao materiaDao;

    @Mock
    private MateriaDtoToMateriaEntity materiaDtoToMateriaEntity;

    @InjectMocks
    private MateriaServiceCrearImpl materiaServiceCrear;

    private MateriaDto materiaDto;
    private MateriaEntity materiaEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        materiaDto = new MateriaDto(1l, "abc");
        materiaEntity = new MateriaEntity(1l, LocalDateTime.now(), new ArrayList<ClaseEntity>(), "abc");
    }

    @Test
    void ejecutar() {
        Mockito.when(materiaDtoToMateriaEntity.dtoResponseToEntity(Mockito.any())).thenReturn(materiaEntity);
        Mockito.when(materiaDao.save(Mockito.any())).thenReturn(materiaEntity);
        assertNotNull(materiaServiceCrear.ejecutar(this.materiaDto));
    }
}