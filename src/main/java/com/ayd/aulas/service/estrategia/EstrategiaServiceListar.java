package com.ayd.aulas.service.estrategia;

import com.ayd.aulas.dto.EstrategiaDto;
import com.ayd.aulas.dto.EstrategiaResponseDto;

import java.util.List;

public interface EstrategiaServiceListar {

    List<EstrategiaResponseDto> ejecutar();
}
