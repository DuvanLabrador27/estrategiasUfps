package com.ayd.aulas.dao;

import com.ayd.aulas.entity.intermedias.ClaseEstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseEstudianteDao extends JpaRepository<ClaseEstudianteEntity, Long> {
}
