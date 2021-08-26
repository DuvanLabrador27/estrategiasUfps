package com.ayd.aulas.dto;

import lombok.Data;

import java.util.List;

@Data
public class AulaDto {
    private Long id;
    private String nombre;
    private List<GrupoDto> grupos;
}
