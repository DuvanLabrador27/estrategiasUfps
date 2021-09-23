package com.ayd.aulas.dao;

import com.ayd.aulas.entity.intermedias.ClaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClaseDao extends JpaRepository<ClaseEntity, Long> {

    Optional<ClaseEntity> findByAnioIdAndDocenteIdAndGrupoIdAndMateriaId(Long anio, Long docente, Long grupo, Long materia);
}
