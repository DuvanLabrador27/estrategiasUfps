package com.ayd.aulas.controller;

import com.ayd.aulas.dto.ClaseEstrategiaDto;
import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.dto.ClaseResponseDto;
import com.ayd.aulas.service.clase.AsignarClaseMateriaService;
import com.ayd.aulas.service.clase.AsignarDocenteClaseMateriaService;
import com.ayd.aulas.service.clase.AsignarEstrategiaClaseService;
import com.ayd.aulas.service.clase.AsignarEstudianteClaseService;
import com.ayd.aulas.service.clase.ListarClasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clase")
public class ClaseController {

    @Autowired
    private AsignarClaseMateriaService asignarClaseMateriaService;

    @PostMapping("/asignar-materia-clase")
    @ResponseBody
    public ClaseResponseDto asignarCalseMateria(@RequestBody ClaseRequestDto claseRequestDto) {
        return asignarClaseMateriaService.ejecutar(claseRequestDto);
    }

    @Autowired
    private AsignarDocenteClaseMateriaService asignarDocenteClaseMateriaService;

    @PostMapping("/asignar-docente-materia-clase")
    @ResponseBody
    public void asignarDocenteClaseMateria(@RequestBody ClaseRequestDto claseRequestDto) {
         asignarDocenteClaseMateriaService.ejecutar(claseRequestDto);
    }

    @Autowired
    private ListarClasesService listarClasesService;

    @GetMapping
    @ResponseBody
    public List<ClaseResponseDto> listar(){
        return listarClasesService.ejecutar();
    }

    @Autowired
    private AsignarEstrategiaClaseService asignarEstrategiaClaseService;

    @PostMapping("/asignar-estrategia-clase")
    public void asignarEstrategiaClase(@RequestBody ClaseEstrategiaDto estrategiaDto) {
        this.asignarEstrategiaClaseService.ejecutar(estrategiaDto);
    }

    @Autowired
    private AsignarEstudianteClaseService asignarEstudianteClaseService;

    @PostMapping("/asignar-estudiante-clase")
    public void asignarEstudianteClase(@RequestBody ClaseRequestDto claseRequestDto) {
        asignarEstudianteClaseService.ejecutar(claseRequestDto);
    }
}
