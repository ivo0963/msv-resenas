package com.example.msvc_resenas.service;

import com.example.msvc_resenas.client.CursoClient;
import com.example.msvc_resenas.client.UsuarioClient;
import com.example.msvc_resenas.model.Resena;
import com.example.msvc_resenas.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private CursoClient cursoClient;

    public Resena guardarResena(Resena resena) {

        if (usuarioClient.obtenerUsuario(resena.getUsuarioId()) == null) {
            throw new RuntimeException("Error: El usuario no existe.");
        }

        try {
            cursoClient.obtenerCurso(resena.getCursoId());
        } catch (Exception e) {
            throw new RuntimeException("Error: El curso no existe.");
        }

        return resenaRepository.save(resena);
    }

    public List<Resena> listarPorCurso(Long cursoId) {
        return resenaRepository.findByCursoId(cursoId);
    }

    public List<Resena> listarTodas() {
        return resenaRepository.findAll();
    }
}