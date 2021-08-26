package com.ayd.aulas.service.docente;

import com.ayd.aulas.dto.AulaDto;
import com.ayd.aulas.dto.DocenteDto;
import com.ayd.aulas.dto.DocenteResponseDto;

public interface DocenteServiceCrear {

    Long ejecutar(DocenteResponseDto docenteDto);
}
