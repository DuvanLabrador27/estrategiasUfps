package com.ayd.aulas.dto;

import lombok.Data;

import java.util.List;

@Data
public class GrupoDto {


    private Long id;
    private String nombre;
    private List<MateriaDto> materias;
    private DocenteDto docente;
    private List<EstudianteDto> estudiantes;
    private List<EstrategiaDto> estrategias;
}
