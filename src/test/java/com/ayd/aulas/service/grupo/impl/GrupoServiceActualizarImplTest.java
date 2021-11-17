package com.ayd.aulas.service.grupo.impl;

import com.ayd.aulas.dao.GrupoDao;
import com.ayd.aulas.dto.GrupoDto;
import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.entity.GrupoEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class GrupoServiceActualizarImplTest {

    private GrupoEntity grupoEntity;
    private GrupoDto grupoDto;
    private GrupoResponseDto grupoResponseDto;
    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        grupoDto = new GrupoDto();
        grupoEntity = new GrupoEntity();
    }

    @Mock
    private GrupoDao grupoDao;

    @InjectMocks
    private GrupoServiceActualizarImpl grupoServiceActualizar;

    @Test
    void ejecutar() {
        Mockito.when(grupoDao.findById(Mockito.anyLong())).thenReturn(
                java.util.Optional.ofNullable(grupoEntity)
        );
        Mockito.when(grupoDao.save(Mockito.any())).thenReturn(grupoEntity);
//        Assert.assert(grupoServiceActualizar.ejecutar(grupoResponseDto));
    }
}