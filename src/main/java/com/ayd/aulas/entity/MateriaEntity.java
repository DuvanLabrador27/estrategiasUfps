package com.ayd.aulas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private Long id;
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JoinTable(name = "grupo_materia",
    joinColumns = {@JoinColumn(name = "grupo_id")},
    inverseJoinColumns = {@JoinColumn(name = "materia_id")})
    private List<GrupoEntity> grupos;

}
