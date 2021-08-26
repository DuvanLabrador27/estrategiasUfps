package com.ayd.aulas.controller;

import com.ayd.aulas.dto.MateriaResponseDto;
import com.ayd.aulas.service.materia.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")
public class MateriaController {

    @Autowired
    private MateriaServiceModificar materiaServiceModificar;

    @Autowired
    private MateriaServiceListar materiaServiceListar;

    @Autowired
    private MateriaServiceEliminar materiaServiceEliminar;

    @Autowired
    private MateriaServiceConsulta materiaServiceConsulta;

    @Autowired
    private MateriaServiceCrear materiaServiceCrear;

    @PostMapping("/crear")
    @ResponseBody
    public Long crear(@RequestBody MateriaResponseDto aulaDto) {
        return materiaServiceCrear.ejecutar(aulaDto);
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<MateriaResponseDto> listar() {
        return materiaServiceListar.ejecutar();
    }

    @GetMapping("/buscar-nombre")
    @ResponseBody
    public MateriaResponseDto buscarNombre(String nombre) {
        return materiaServiceConsulta.ejecutar(nombre);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        materiaServiceEliminar.ejecutar(id);
    }

    @PutMapping("/actualizar")
    @ResponseBody
    void actualizar(@RequestBody MateriaResponseDto aulaDto) {
        materiaServiceModificar.ejecutar(aulaDto);
    }
}
