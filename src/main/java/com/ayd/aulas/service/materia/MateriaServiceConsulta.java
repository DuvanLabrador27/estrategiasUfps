package com.ayd.aulas.service.materia;

import com.ayd.aulas.dto.ClaseResponseDto;
import com.ayd.aulas.dto.MateriaDto;

public interface MateriaServiceConsulta {

    MateriaDto ejecutar(String nombre);
}
