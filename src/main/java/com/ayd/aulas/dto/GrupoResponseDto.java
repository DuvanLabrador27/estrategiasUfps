package com.ayd.aulas.dto;

import lombok.Data;

import java.util.List;

@Data
public class GrupoResponseDto {


    private Long id;
    private String nombre;
    private Long aula;
    private Long docente;
    private Long estudiantes;
    private List<Long> estrategias;
}
