package com.ayd.aulas.controller;

import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.service.docente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteServiceModificar docenteServiceModificar;

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody DocenteResponseDto docenteDto){
        docenteServiceModificar.ejecutar(docenteDto);
    }

    @Autowired
    private DocenteServiceEliminar docenteServiceEliminar;

    @DeleteMapping("/eliminar/{id}")
    private void eliminar(@PathVariable Long id) {
        docenteServiceEliminar.ejectar(id);
    }

    @Autowired
    private DocenteServiceListar docenteServiceListar;

    @GetMapping("/listar-todo")
    @ResponseBody
    public List<DocenteResponseDto> listarTodo(){
        return docenteServiceListar.ejecutar();
    }

    @Autowired
    private DocenteServiceCrear docenteServiceCrear;

    @PostMapping("/crear")
    @ResponseBody
    private Long crear(@RequestBody DocenteResponseDto docenteDto){
        return docenteServiceCrear.ejecutar(docenteDto);
    }

    @Autowired
    private DocenteLoginService docenteLoginService;

    @PostMapping("/login")
    @ResponseBody
    private boolean login(@RequestBody DocenteResponseDto responseDto) {
        return docenteLoginService.ejecutar(responseDto);
    }

}
