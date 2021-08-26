package com.ayd.aulas.service.estudiante;

import com.ayd.aulas.dto.EstudianteDto;
import com.ayd.aulas.dto.EstudianteResponseDto;

public interface EstudianteServiceBuscarNombre {

    EstudianteResponseDto ejecutar(String nombre);
}
