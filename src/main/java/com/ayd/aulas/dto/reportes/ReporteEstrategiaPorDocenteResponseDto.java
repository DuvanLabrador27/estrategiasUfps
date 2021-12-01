package com.ayd.aulas.dto.reportes;

import lombok.Data;
import com.ayd.aulas.dto.EstrategiaDto;
import com.ayd.aulas.dto.DocenteDto;

import java.util.List;

@Data
public class ReporteEstrategiaPorDocenteResponseDto {

    private int totalEstrategias;
    private List<EstrategiaDto> estrategias;
    private DocenteDto docenteDto;
}
