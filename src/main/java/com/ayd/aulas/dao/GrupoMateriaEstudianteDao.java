package com.ayd.aulas.dao;

import com.ayd.aulas.entity.GrupoMateriaEstudianteEntity;
import com.ayd.aulas.entity.compositeKey.GrupoMateriaEstudianteKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoMateriaEstudianteDao extends JpaRepository<GrupoMateriaEstudianteEntity, GrupoMateriaEstudianteKey> {
}
