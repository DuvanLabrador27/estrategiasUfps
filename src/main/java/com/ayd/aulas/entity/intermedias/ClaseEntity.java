package com.ayd.aulas.entity.intermedias;


import com.ayd.aulas.entity.AnioEntity;
import com.ayd.aulas.entity.DocenteEntity;
import com.ayd.aulas.entity.GrupoEntity;
import com.ayd.aulas.entity.MateriaEntity;
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
@Table(name = "clase")
@AllArgsConstructor
@NoArgsConstructor
public class ClaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    private AnioEntity anio;

    @ManyToOne
    @ToString.Exclude
    private GrupoEntity grupo;

    @ManyToOne
    @ToString.Exclude
    private DocenteEntity docente;

    @ManyToOne
    @ToString.Exclude
    private MateriaEntity materia;
}
