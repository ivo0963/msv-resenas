package com.example.msvc_resenas.controller;

import com.example.msvc_resenas.model.Resena;
import com.example.msvc_resenas.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @PostMapping
    public Resena crear(@RequestBody Resena resena) {
        return resenaService.guardarResena(resena);
    }

    @GetMapping("/curso/{idCurso}")
    public List<Resena> listarPorCurso(@PathVariable Long idCurso) {
        return resenaService.listarPorCurso(idCurso);
    }

    @GetMapping
    public List<Resena> listarTodas() {
        return resenaService.listarTodas();
    }
}