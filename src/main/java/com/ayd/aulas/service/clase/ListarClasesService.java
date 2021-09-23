package com.ayd.aulas.service.clase;

import com.ayd.aulas.dto.ClaseResponseDto;
import com.ayd.aulas.entity.intermedias.ClaseEntity;

import java.util.List;

public interface ListarClasesService {

    List<ClaseResponseDto> ejecutar();
}
