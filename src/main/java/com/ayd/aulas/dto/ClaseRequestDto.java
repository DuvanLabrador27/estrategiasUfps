package com.ayd.aulas.dto;

import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Data
public class ClaseRequestDto {

    private Long clase;
    private Long materia;
    private String nombre;
    private Long grupo;
    private Long docente;
    private Long estudiante;
    private String periodo;
}
