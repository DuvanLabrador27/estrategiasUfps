package com.ayd.aulas.entity.intermedias;

import com.ayd.aulas.entity.EstrategiaEntity;
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
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "clase_estrategia")
@AllArgsConstructor
@NoArgsConstructor
public class ClaseEstrategiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    private EstrategiaEntity estrategia;

    @ManyToOne
    @ToString.Exclude
    private ClaseEntity clase;

    private LocalDateTime fechaIncio;
    private LocalDateTime fechaFin;
    private Boolean estado;

}
