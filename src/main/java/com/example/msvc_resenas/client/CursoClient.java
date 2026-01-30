package com.example.msvc_resenas.client;

import com.example.msvc_resenas.model.CursoDTO; // Lo creamos en el paso 2
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "proyecto-principal")
public interface CursoClient {

    @GetMapping("/cursos/{id}")
    CursoDTO obtenerCurso(@PathVariable Long id);
}