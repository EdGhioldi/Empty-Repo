package com.dudicorp.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_curso;
    private String nombre;
    private String modalidad;
    private Date fecha_finalizacion;
    @OneToMany
    private List<Tema> temaDelCurso;

    public Curso(){};

    public Curso(Long id_curso, String nombre, String modalidad, Date fecha_finalizacion, List<Tema> temaDelCurso) {
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.fecha_finalizacion = fecha_finalizacion;
        this.temaDelCurso = temaDelCurso;
    }
}
