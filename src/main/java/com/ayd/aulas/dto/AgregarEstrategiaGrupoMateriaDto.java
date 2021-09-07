package com.ayd.aulas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgregarEstrategiaGrupoMateriaDto {

    @NonNull
    private List<Long> estrategias;

    @NonNull
    private Long grupo;

    @NonNull
    private Long materia;
}
