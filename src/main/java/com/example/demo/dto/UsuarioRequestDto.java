package com.example.demo.dto;

import com.example.demo.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDto {
    String username;
    String senha;
    Boolean isAdmin;
    PerfilUsuarioRequestDto perfilUsuario;
    List<EnderecoRequestDto> enderecos;
}
