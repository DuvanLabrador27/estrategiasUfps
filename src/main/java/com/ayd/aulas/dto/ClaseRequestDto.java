package com.ayd.aulas.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ClaseRequestDto {

    private Long clase;
    private Long materia;
    private String nombre;
    private Long grupo;
    private Long docente;
    private LocalDateTime fecha;
}
