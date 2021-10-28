package com.ayd.aulas.dao;

import com.ayd.aulas.entity.AnioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnioDao extends JpaRepository<AnioEntity, Long> {

    Optional<AnioEntity> findByAnioAndSemestre(Integer anio, Integer semestre);
}
