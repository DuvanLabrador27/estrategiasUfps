package com.ayd.aulas.service.estrategia.impl;

import com.ayd.aulas.dao.EstrategiaDao;
import com.ayd.aulas.dto.EstrategiaDto;
import com.ayd.aulas.dto.EstrategiaResponseDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstrategiaServiceListarImplTest {

    private EstrategiaEntity estrategiaEntity;
    private EstrategiaDto estrategiaDto;
    private EstrategiaResponseDto estrategiaResponseDto;
    private List<EstrategiaResponseDto> estrategiaResponseDtos;
    private List<EstrategiaEntity> estrategiaEntities;

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

        estrategiaResponseDtos = new ArrayList<>();
        estrategiaResponseDtos.add(estrategiaResponseDto);
        estrategiaEntities = new ArrayList<>();
        estrategiaEntities.add(estrategiaEntity);
    }

    @Mock
    private EstrategiaDao estrategiaDao;

    @Test
    void ejecutar() {
        Mockito.when(estrategiaDao.findAll()).thenReturn(estrategiaEntities);

    }
}