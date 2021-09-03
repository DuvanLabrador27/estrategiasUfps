package com.ayd.aulas.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "estrategia")
public class EstrategiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Date creacion;
    private String descripcion;
    private String nombre;

    @OneToMany(
            mappedBy = "estrategia",
            fetch = FetchType.LAZY
    )
    private List<GrupoEstrategiaEntity> grupoEstrategia;
}
