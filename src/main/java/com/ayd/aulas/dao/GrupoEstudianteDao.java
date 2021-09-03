package com.ayd.aulas.dao;

import com.ayd.aulas.entity.GrupoEstudianteEntity;
import com.ayd.aulas.entity.compositeKey.GrupoEstudianteKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoEstudianteDao extends JpaRepository<GrupoEstudianteEntity, GrupoEstudianteKey> {
}
