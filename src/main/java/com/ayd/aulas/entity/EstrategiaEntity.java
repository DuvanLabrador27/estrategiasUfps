package com.ayd.aulas.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "estrategia")
public class EstrategiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date creacion;
    private String descripcion;
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name = "grupo_estrategia",
            joinColumns = {@JoinColumn(name = "grupo_id")},
            inverseJoinColumns = {@JoinColumn(name = "estrategia_id")})
    private List<GrupoEntity> grupos;
}
