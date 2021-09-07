package com.ayd.aulas.controller;

import com.ayd.aulas.dto.AgregarEstudiantesGrupoMateriaDto;
import com.ayd.aulas.service.grupoMateriaEstudiante.AgregarEstudiantesGrupoMateriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupo-mateira")
@Api(tags = {"Controlador para Actualizar relacion de grupo con materia"})
public class GrupoMateriaController {

    @Autowired
    private AgregarEstudiantesGrupoMateriaService agregarEstudiantesGrupoMateriaService;

    @PutMapping
    @ResponseBody
    @ApiOperation(value = "Actualiza relacion de grupo con materia")
    public void eliminarGrupoMateria(@RequestBody AgregarEstudiantesGrupoMateriaDto dto) {
        agregarEstudiantesGrupoMateriaService.ejecutar(dto);
    }
}
