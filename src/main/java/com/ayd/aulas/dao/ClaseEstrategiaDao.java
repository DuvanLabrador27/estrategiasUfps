package com.ayd.aulas.dao;

import com.ayd.aulas.entity.intermedias.ClaseEstrategiaEntity;
import com.ayd.aulas.entity.intermedias.ClaseEstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClaseEstrategiaDao extends JpaRepository<ClaseEstrategiaEntity, Long> {

    @Query(value = "select * from clase_estrategia where clase_id = :clase and estrategia_id = :estrategia", nativeQuery = true)
    Optional<ClaseEstrategiaEntity> findByEstrategiaAndClase(@Param("estrategia") Long estrategia, @Param("clase") Long clase);
}
