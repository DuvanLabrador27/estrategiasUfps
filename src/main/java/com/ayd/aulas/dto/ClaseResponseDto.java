package com.ayd.aulas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClaseResponseDto {

    private Long clase;
    private String materia;
    private String grupo;
    private String docente;
    private String periodo;

}
