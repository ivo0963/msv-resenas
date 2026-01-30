package com.example.msvc_resenas.controller;

import com.example.msvc_resenas.model.Resena;
import com.example.msvc_resenas.service.ResenaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ResenaController.class)
public class ResenaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ResenaService resenaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void crearResena() throws Exception {
        Resena resena = new Resena();
        resena.setId(1L);
        resena.setUsuarioId(1L);
        resena.setCursoId(1L);
        resena.setComentario("Muy buen curso, recomendado");
        resena.setCalificacion(5);

        when(resenaService.guardarResena(any(Resena.class))).thenReturn(resena);

        Map<String, Object> payload = new HashMap<>();
        payload.put("usuarioId", 1);
        payload.put("cursoId", 1);
        payload.put("comentario", "Muy buen curso, recomendado");
        payload.put("calificacion", 5);

        mockMvc.perform(post("/resenas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isOk());
    }
}