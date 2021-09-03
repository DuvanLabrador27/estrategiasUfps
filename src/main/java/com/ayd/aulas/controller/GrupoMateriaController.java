package com.ayd.aulas.controller;

import com.ayd.aulas.dto.MateriaResponseDto;
import com.ayd.aulas.service.grupoMateria.AgregarGrupoMateriaService;
import com.ayd.aulas.service.grupoMateria.EliminarGrupoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "grupo-mateira")
public class GrupoMateriaController {

    @Autowired
    private AgregarGrupoMateriaService agregarGrupoMateriaService;

    @PostMapping
    @ResponseBody
    public void agregarGrupoMateria(@RequestBody MateriaResponseDto responseDto) {
        agregarGrupoMateriaService.ejecutar(responseDto);
    }

    @Autowired
    private EliminarGrupoMateriaService eliminarGrupoMateriaService;
    @DeleteMapping
    @ResponseBody
    public void eliminarGrupoMateria(@RequestBody MateriaResponseDto responseDto) {
        eliminarGrupoMateriaService.ejecutar(responseDto);
    }
}
