package com.ayd.aulas.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClaseEstrategiaDto {

    private Long id;
    private Long estrategia;
    private Long clase;
    private LocalDateTime fechaIncio;
    private LocalDateTime fechaFin;
    private Boolean estado;

}
