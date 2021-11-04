package com.ayd.aulas.dao;

import com.ayd.aulas.entity.intermedias.ClaseEstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClaseEstudianteDao extends JpaRepository<ClaseEstudianteEntity, Long> {

    @Query(value = "select * from clase_estudiante where clase_id = :clase and estudiante_id = :estudiante", nativeQuery = true)
    Optional<ClaseEstudianteEntity> findByEstudianteAndClase(@Param("estudiante") Long estudiante, @Param("clase") Long clase);
}
