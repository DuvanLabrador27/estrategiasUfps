package com.ayd.aulas.dao;

import com.ayd.aulas.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteDao extends JpaRepository<EstudianteEntity, Long> {

    Optional<EstudianteEntity> findByNombre(String nombre);
}
