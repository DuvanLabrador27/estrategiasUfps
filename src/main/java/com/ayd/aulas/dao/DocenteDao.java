package com.ayd.aulas.dao;

import com.ayd.aulas.entity.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocenteDao extends JpaRepository<DocenteEntity, Long> {

    Optional<DocenteEntity> findByNombre(String nombre);

    Optional<DocenteEntity> findByUsername(String correo);
}
