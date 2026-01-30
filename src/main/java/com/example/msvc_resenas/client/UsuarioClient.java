package com.example.msvc_resenas.client;

import com.example.msvc_resenas.model.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-usuarios")
public interface UsuarioClient {

    @GetMapping("/{id}")
    UsuarioDTO obtenerUsuario(@PathVariable Long id);
}