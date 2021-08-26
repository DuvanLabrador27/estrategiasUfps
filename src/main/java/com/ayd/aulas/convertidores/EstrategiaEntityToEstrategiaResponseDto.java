package com.ayd.aulas.convertidores;

import com.ayd.aulas.dto.EstrategiaResponseDto;
import com.ayd.aulas.entity.EstrategiaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EstrategiaEntityToEstrategiaResponseDto{

    public EstrategiaResponseDto entityToResonse (EstrategiaEntity estrategiaEntity) {
        EstrategiaResponseDto responseDto = new EstrategiaResponseDto();
        responseDto.setGrupos(new ArrayList<>());
        responseDto.setId(estrategiaEntity.getId());
        responseDto.setCreacion(estrategiaEntity.getCreacion());
        responseDto.setDescripcion(estrategiaEntity.getDescripcion());
        responseDto.setNombre(estrategiaEntity.getNombre());
        estrategiaEntity.getGrupos().forEach(
                entity -> responseDto.getGrupos().add(entity.getId())
        );
        return responseDto;
    }
}
