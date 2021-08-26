package com.ayd.aulas.dto;

import lombok.Data;

import java.util.List;

@Data
public class GrupoDto {


    private Long id;
    private String nombre;
    private MateriaDto aula;
    private DocenteDto docente;
    private EstudianteDto estudiantes;
    private List<EstrategiaDto> estrategias;
}
