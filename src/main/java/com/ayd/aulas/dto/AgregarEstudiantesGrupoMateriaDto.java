package com.ayd.aulas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgregarEstudiantesGrupoMateriaDto {

    @NonNull
    private List<Long> estudiantes;
    @NonNull
    private Long materia;
    @NonNull
    private Long grupo;

}
