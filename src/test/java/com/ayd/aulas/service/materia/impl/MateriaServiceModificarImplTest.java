package com.ayd.aulas.service.materia.impl;

import com.ayd.aulas.dao.MateriaDao;
import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.dto.ClaseResponseDto;
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

class MateriaServiceModificarImplTest {

    private MateriaEntity materiaEntity;
    private MateriaDto materiaDto;
    private MateriaDto materiaDtoMod;
    private ClaseRequestDto requestDto;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        materiaDto = new MateriaDto(1l, "abc");
        materiaDtoMod = new MateriaDto(1l, "ab");

        materiaEntity = new MateriaEntity(1l, LocalDateTime.now(), new ArrayList<ClaseEntity>(), "abc");
        requestDto = new ClaseRequestDto();
        requestDto.setMateria(materiaDto.getId());
        requestDto.setClase(1l);
        requestDto.setDocente(1l);
        requestDto.setEstudiante(1l);
        requestDto.setGrupo(1l);
        requestDto.setNombre("bca");

    }

    @Mock
    private MateriaDao materiaDao;

    @InjectMocks
    private MateriaServiceModificarImpl materiaServiceModificar;

    @Test
    void ejecutar() {
        Mockito.when(materiaDao.findById(Mockito.any())).thenReturn(java.util.Optional.ofNullable(materiaEntity));
        Mockito.when(materiaDao.save(Mockito.any())).thenReturn(materiaEntity);
        assertEquals(materiaServiceModificar.ejecutar(requestDto).getMateria(), "bca");
    }
}