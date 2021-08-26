package com.ayd.aulas.dto;

import lombok.Data;

import java.util.List;

@Data
public class MateriaResponseDto {
    private Long id;
    private String nombre;
    private List<Long> grupos;
}
