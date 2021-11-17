package com.ayd.aulas.service.estudiante.impl;

import com.ayd.aulas.convertidores.EstudianteEntityToEstudianteResponseDto;
import com.ayd.aulas.dao.EstudianteDao;
import com.ayd.aulas.dto.EstudianteDto;
import com.ayd.aulas.dto.EstudianteResponseDto;
import com.ayd.aulas.entity.EstudianteEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

class EstudianteServiceBuscarNombreImplTest {

    private EstudianteEntity estudianteEntity;
    private EstudianteDto estudianteDto;
    private EstudianteResponseDto estudianteResponseDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        estudianteDto = new EstudianteDto();

        estudianteEntity = new EstudianteEntity();
        estudianteEntity.setNombre("PRUEBA");
        estudianteEntity.setApellido("UNITARIA");
        estudianteEntity.setAnioGrupoEstudiantes(new ArrayList<>());
        estudianteEntity.setContrasena("123321");
        estudianteEntity.setCorreo("prueba@unitarias.com");
        estudianteEntity.setId(1l);

        estudianteResponseDto = new EstudianteResponseDto();
        estudianteResponseDto.setNombre("PRUEBA");
        estudianteResponseDto.setApellido("UNITARIAS");
        estudianteResponseDto.setContrasena("123321");
        estudianteResponseDto.setCorreo("prueba@unitaria.com");
        estudianteResponseDto.setId(1l);
    }

    @Mock
    private EstudianteDao estudianteDao;

    @Mock
    private EstudianteEntityToEstudianteResponseDto toEstudianteResponseDto;

    @InjectMocks
    private EstudianteServiceBuscarNombreImpl estudianteServiceBuscarNombre;

    @Test
    void ejecutar() {
        Mockito.when(estudianteDao.findByNombre(Mockito.anyString())).thenReturn(
                java.util.Optional.ofNullable(estudianteEntity)
        );
        Mockito.when(toEstudianteResponseDto.entityToResponseDto(Mockito.any())).thenReturn(estudianteResponseDto);
        Assert.assertNotNull(estudianteServiceBuscarNombre.ejecutar(Mockito.anyString()));
    }
}