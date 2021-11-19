package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteResponseDtoToDocenteEntity;
import com.ayd.aulas.dao.DocenteDao;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.entity.DocenteEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DocenteServiceCrearImplTest {

    private DocenteEntity docenteEntity;
    private DocenteDto docenteDto;
    private DocenteResponseDto docenteResponseDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        docenteEntity = new DocenteEntity();
        docenteEntity.setNombre("PRUEBA");
        docenteEntity.setAnioGrupos(new ArrayList<>());
        docenteEntity.setApellido("UNITARIA");
        docenteEntity.setContrasena("123321");
        docenteEntity.setCorreo("prueba@unitaria.com");
        docenteEntity.setId(1l);

        docenteResponseDto = new DocenteResponseDto();
        docenteResponseDto.setNombre("PRUEBA");
        docenteResponseDto.setApellido("Unitaria");
        docenteResponseDto.setContrasena("1233321");
        docenteResponseDto.setCorreo("prueba@unitaria.com");
        docenteResponseDto.setId(1l);
    }

    @Mock
    private DocenteDao docenteDao;

    @Mock
    private DocenteResponseDtoToDocenteEntity toDocenteEntity;

    @InjectMocks
    private DocenteServiceCrearImpl docenteServiceCrear;

    @Test
    void ejecutar() {
        Mockito.when(docenteDao.findByNombre(Mockito.anyString()))
                .thenReturn(
                        java.util.Optional.ofNullable(null)
                );
        Mockito.when(docenteDao.save(Mockito.any()))
                .thenReturn(
                       docenteEntity
                );
        Mockito.when(toDocenteEntity.repsonseDtoToEntity(Mockito.any())).thenReturn(docenteEntity);
        Assert.assertNotNull(docenteServiceCrear.ejecutar(docenteResponseDto));
    }
}