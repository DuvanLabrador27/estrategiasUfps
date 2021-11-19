package com.ayd.aulas.service.estrategia.impl;

import com.ayd.aulas.convertidores.EstrategiaResponseToEstrategiaEntity;
import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dto.EstrategiaDto;
import com.ayd.aulas.dto.EstrategiaResponseDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class EstrategiaServiceCrearImplTest {

    private EstrategiaEntity estrategiaEntity;
    private EstrategiaDto estrategiaDto;
    private EstrategiaResponseDto estrategiaResponseDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        estrategiaDto = new EstrategiaDto();

        estrategiaEntity = new EstrategiaEntity();
        estrategiaEntity.setNombre("PRUEBA");
        estrategiaEntity.setDescripcion("UNITARIA");
        estrategiaEntity.setId(1l);

        estrategiaResponseDto = new EstrategiaResponseDto();
        estrategiaResponseDto.setNombre("PRUEBA");
        estrategiaResponseDto.setDescripcion("UNITARIAS");
        estrategiaResponseDto.setId(1l);
    }

    @Mock
    private EstrategiaDao estrategiaDao;

    @Mock
    private EstrategiaResponseToEstrategiaEntity toEstrategiaEntity;

    @InjectMocks
    private EstrategiaServiceCrearImpl estrategiaServiceCrear;

    @Test
    void ejecutar() {
        Mockito.when(estrategiaDao.save(Mockito.any())).thenReturn(estrategiaEntity);
        Assert.assertNotNull(estrategiaServiceCrear.ejecutar(estrategiaResponseDto));
    }
}