package com.ayd.aulas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materia")
public class MateriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nombre;

    @OneToMany(
            mappedBy = "materia",
            fetch = FetchType.LAZY
    )
    private List<GrupoMateriaEstudianteEntity> grupoMateriaEstudiante;

    @OneToMany(
            mappedBy = "materia",
            fetch = FetchType.LAZY
    )
    private List<GrupoMateriaEstrategiaEntity> grupoMateriaEstrategia;

}
