package com.ayd.aulas.controller;

import com.ayd.aulas.dto.EstrategiaResponseDto;
import com.ayd.aulas.service.estrategia.EstrategiaServiceBuscarNombre;
import com.ayd.aulas.service.estrategia.EstrategiaServiceCrear;
import com.ayd.aulas.service.estrategia.EstrategiaServiceListar;
import com.ayd.aulas.service.estrategia.EstrategiaServicioEliminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estrategia")
public class EstrategiaController {

    @Autowired
    private EstrategiaServiceCrear estrategiaServiceCrear;

    @PostMapping("crear")
    @ResponseBody
    public Long crear(@RequestBody EstrategiaResponseDto estrategiaDto) {
        return estrategiaServiceCrear.ejecutar(estrategiaDto);
    }

    @Autowired
    private EstrategiaServiceBuscarNombre estrategiaServiceBuscarNombre;

    @GetMapping("/buscar-nombre/{nombre}")
    public EstrategiaResponseDto buscarNombre(@PathVariable String nombre) {
        return estrategiaServiceBuscarNombre.ejecutar(nombre);
    }

    @Autowired
    private EstrategiaServiceListar estrategiaServiceListar;

    @GetMapping("/listar")
    public List<EstrategiaResponseDto> listar() {
        return estrategiaServiceListar.ejecutar();
    }

    @Autowired
    private EstrategiaServicioEliminar estrategiaServicioEliminar;

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        estrategiaServicioEliminar.ejecutar(id);
    }
}
