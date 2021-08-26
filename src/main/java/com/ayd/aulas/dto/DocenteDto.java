package com.ayd.aulas.dto;

import lombok.Data;

import java.util.List;

@Data
public class DocenteDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private List<GrupoDto> grupos;
}
