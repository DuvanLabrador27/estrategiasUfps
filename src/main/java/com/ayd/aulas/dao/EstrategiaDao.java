package com.ayd.aulas.dao;

import com.ayd.aulas.entity.EstrategiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstrategiaDao extends JpaRepository<EstrategiaEntity, Long> {

    Optional<EstrategiaEntity> findByNombre(String nombre);
}
