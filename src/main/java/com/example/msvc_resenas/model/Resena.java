package com.example.msvc_resenas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "resenas")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentario;
    private Integer calificacion;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "curso_id")
    private Long cursoId;
}