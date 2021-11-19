package com.ayd.aulas.service.docente.impl;

import com.ayd.aulas.convertidores.DocenteEntityToDocenteResponseDto;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DocenteServiceListarImplTest {

    private DocenteEntity docenteEntity;
    private DocenteDto docenteDto;
    private DocenteResponseDto docenteResponseDto;
    private List<DocenteEntity> docenteEntities;
    private List<DocenteResponseDto> docenteResponseDtos;


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

        docenteResponseDtos = new ArrayList<>();
        docenteEntities = new ArrayList<>();
        docenteResponseDtos.add(docenteResponseDto);
        docenteEntities.add(docenteEntity);
    }

    @Mock
    private DocenteDao docenteDao;

    @Mock
    private DocenteEntityToDocenteResponseDto toDocenteResponseDto;

    @InjectMocks
    private DocenteServiceListarImpl docenteServiceListar;

    @Test
    void ejecutar() {
        Mockito.when(docenteDao.findAll()).thenReturn(docenteEntities);
        Mockito.when(toDocenteResponseDto.entityToResponseDto(Mockito.any())).thenReturn(docenteResponseDto);
        Assert.assertEquals(1l, docenteServiceListar.ejecutar().size());
    }
}