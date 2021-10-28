package com.ayd.aulas.service.materia;

import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.dto.ClaseResponseDto;

public interface MateriaServiceModificar {

    ClaseResponseDto ejecutar(ClaseRequestDto requestDto);
}
