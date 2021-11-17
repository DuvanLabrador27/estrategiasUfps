package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.convertidores.MateriaEntityToMateriaDto;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MateriaServiceConsultaImplTest {

    private MateriaEntity materiaEntity;
    private MateriaDto materiaDto;
    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        materiaDto = new MateriaDto(1l, "abc");
        materiaEntity = new MateriaEntity(1l, LocalDateTime.now(), new ArrayList<ClaseEntity>(), "abc");
    }

    @Mock
    private MateriaDao materiaDao;

    @InjectMocks
    private MateriaServiceConsultaImpl materiaServiceConsulta;

    @Test
    void ejecutar() {
        Mockito.when(materiaDao.findByNombre(Mockito.anyString())).thenReturn(java.util.Optional.ofNullable(materiaEntity));
        assertNotNull(materiaServiceConsulta.ejecutar(Mockito.anyString()));
        assertEquals(1l, 1l);
    }
}