package com.ayd.aulas.controller;

import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.dto.ClaseResponseDto;
import com.ayd.aulas.dto.MateriaDto;
import com.ayd.aulas.service.clase.AsignarDocenteClaseMateriaService;
import com.ayd.aulas.service.materia.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")
public class MateriaController {

    @Autowired
    private AsignarDocenteClaseMateriaService asignarDocenteClaseMateriaService;

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
    public MateriaDto crear(@RequestBody MateriaDto aulaDto) {
        return materiaServiceCrear.ejecutar(aulaDto);
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<MateriaDto> listar() {
        return materiaServiceListar.ejecutar();
    }

    @GetMapping("/buscar-nombre")
    @ResponseBody
    public MateriaDto buscarNombre(String nombre) {
        return materiaServiceConsulta.ejecutar(nombre);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        materiaServiceEliminar.ejecutar(id);
    }

    @PutMapping("/actualizar")
    @ResponseBody
    void actualizar(@RequestBody ClaseRequestDto aulaDto) {
        asignarDocenteClaseMateriaService.ejecutar(aulaDto);
    }
}
