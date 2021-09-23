package com.ayd.aulas.dao;

import com.ayd.aulas.entity.AnioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnioDao extends JpaRepository<AnioEntity, Long> {

    Optional<AnioEntity> findByAnioAndSemestre(Integer anio, Integer semestre);
}
