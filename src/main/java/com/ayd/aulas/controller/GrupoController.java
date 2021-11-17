package com.ayd.aulas.controller;

import com.ayd.aulas.dto.GrupoResponseDto;
import com.ayd.aulas.service.grupo.GrupoServiceActualizar;
import com.ayd.aulas.service.grupo.GrupoServiceCrear;
import com.ayd.aulas.service.grupo.GrupoServiceEliminar;
import com.ayd.aulas.service.grupo.GrupoServiceListar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    private GrupoServiceListar grupoServiceListar;

    @GetMapping("/listar")
    @ResponseBody
    public List<GrupoResponseDto> listar() {
        return grupoServiceListar.ejecutar();
    }

    @Autowired
    private GrupoServiceEliminar grupoServiceEliminar;

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        grupoServiceEliminar.ejecutar(id);
    }

    @Autowired
    private GrupoServiceActualizar grupoServiceActualizar;

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody GrupoResponseDto grupoDto) {
        grupoServiceActualizar.ejecutar(grupoDto);
    }

    @Autowired
    private GrupoServiceCrear grupoServiceCrear;

    @PostMapping("/crear")
    @ResponseBody
    public Long crear(@RequestBody GrupoResponseDto grupoDto) {
        return grupoServiceCrear.ejecutar(grupoDto);
    }


}
