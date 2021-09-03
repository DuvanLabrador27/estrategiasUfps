package com.ayd.aulas.dao;

import com.ayd.aulas.entity.GrupoMateriaEntity;
import com.ayd.aulas.entity.compositeKey.GrupoMateriaKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoMateriaDao extends JpaRepository<GrupoMateriaEntity, GrupoMateriaKey> {
}
