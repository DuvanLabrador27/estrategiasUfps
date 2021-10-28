package com.ayd.aulas.controller;

import com.ayd.aulas.dto.DocenteResponseDto;
import com.ayd.aulas.service.docente.DocenteLoginService;
import com.ayd.aulas.service.docente.DocenteServiceCrear;
import com.ayd.aulas.service.docente.DocenteServiceEliminar;
import com.ayd.aulas.service.docente.DocenteServiceListar;
import com.ayd.aulas.service.docente.DocenteServiceModificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteServiceModificar docenteServiceModificar;

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody DocenteResponseDto docenteDto) {
        docenteServiceModificar.ejecutar(docenteDto);
    }

    @Autowired
    private DocenteServiceEliminar docenteServiceEliminar;

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        docenteServiceEliminar.ejectar(id);
    }

    @Autowired
    private DocenteServiceListar docenteServiceListar;

    @GetMapping("/listar-todo")
    @ResponseBody
    public List<DocenteResponseDto> listarTodo() {
        return docenteServiceListar.ejecutar();
    }

    @Autowired
    private DocenteServiceCrear docenteServiceCrear;

    @PostMapping("/crear")
    @ResponseBody
    public Long crear(@RequestBody DocenteResponseDto docenteDto) {
        return docenteServiceCrear.ejecutar(docenteDto);
    }

    @Autowired
    private DocenteLoginService docenteLoginService;

    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestBody DocenteResponseDto responseDto) {
        return docenteLoginService.ejecutar(responseDto);
    }

}
