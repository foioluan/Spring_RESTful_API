package com.example.demo.controller;

import com.example.demo.domain.PerfilUsuario;
import com.example.demo.service.PerfilUsuarioService;
import com.example.demo.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/perfil")
@AllArgsConstructor
public class PerfilUsuarioController {

    PerfilUsuarioService service;

    @GetMapping
    public PerfilUsuario getById(@PathVariable Long id_usuario) {
        return service.findById(id_usuario);
    }
}
