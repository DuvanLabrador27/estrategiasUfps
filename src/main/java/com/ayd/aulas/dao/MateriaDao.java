package com.ayd.aulas.dao;

import com.ayd.aulas.entity.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MateriaDao extends JpaRepository<MateriaEntity, Long> {

    Optional<MateriaEntity> findByNombre(String nombre);
}
