package com.ayd.aulas.entity.intermedias;

import com.ayd.aulas.entity.EstudianteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "clase_estudiante")
@AllArgsConstructor
@NoArgsConstructor
public class ClaseEstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    private EstudianteEntity estudiante;

    @ManyToOne
    @ToString.Exclude
    private ClaseEntity clase;
}
