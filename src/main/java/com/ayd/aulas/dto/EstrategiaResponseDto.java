package com.ayd.aulas.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EstrategiaResponseDto {

    private Long id;
    private String nombre;
    private Date creacion;
    private String descripcion;
    private List<Long> grupos;
}
