package com.ayd.aulas.service.clase;

import com.ayd.aulas.dto.ClaseRequestDto;
import com.ayd.aulas.dto.ClaseResponseDto;

public interface AsignarClaseMateriaService {

    ClaseResponseDto ejecutar(ClaseRequestDto requestDto);
}
