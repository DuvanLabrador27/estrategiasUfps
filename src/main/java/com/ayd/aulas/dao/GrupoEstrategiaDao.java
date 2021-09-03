package com.ayd.aulas.dao;

import com.ayd.aulas.entity.GrupoEstrategiaEntity;
import com.ayd.aulas.entity.compositeKey.GrupoEstrategiaKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoEstrategiaDao extends JpaRepository<GrupoEstrategiaEntity, GrupoEstrategiaKey> {
}
