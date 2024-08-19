package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilUsuarioResponseDto extends RepresentationModel<PerfilUsuarioResponseDto> {
    String nome;
    String genero;
    String dataNascimento;
}
