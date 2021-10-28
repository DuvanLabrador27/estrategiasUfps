package com.ayd.aulas.dao;

import com.ayd.aulas.entity.intermedias.ClaseEstrategiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseEstrategiaDao extends JpaRepository<ClaseEstrategiaEntity, Long> {
}
