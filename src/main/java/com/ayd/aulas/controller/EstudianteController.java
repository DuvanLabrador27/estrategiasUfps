package com.ayd.aulas.controller;

import com.ayd.aulas.dto.EstudianteDto;
import com.ayd.aulas.dto.EstudianteResponseDto;
import com.ayd.aulas.service.estudiante.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteServiceBuscarNombre estudianteServiceBuscarNombre;

    @Autowired
    private EstudianteServiceListar estudianteServiceListar;

    @Autowired
    private EstudianteServiceCrear estudianteServiceCrear;

    @Autowired
    private EstudianteServiceEliminar estudianteServiceEliminar;

    @Autowired
    private EstudianteServiceActualizar estudianteServiceActualizar;

    @GetMapping("/listar")
    @ResponseBody
    public List<EstudianteResponseDto> listar(){
        return estudianteServiceListar.ejecutar();
    }

    @GetMapping("/buscar-nombre")
    @ResponseBody
    public EstudianteResponseDto buscarNombre(String nombre){
        return estudianteServiceBuscarNombre.ejecutar(nombre);
    }

    @PostMapping("/crear")
    @ResponseBody
    public Long crear(@RequestBody EstudianteResponseDto estudianteDto){
        return estudianteServiceCrear.ejecutar(estudianteDto);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public void actualizar(@RequestBody EstudianteResponseDto estudianteDto){
        estudianteServiceActualizar.ejecutar(estudianteDto);
    }
}
