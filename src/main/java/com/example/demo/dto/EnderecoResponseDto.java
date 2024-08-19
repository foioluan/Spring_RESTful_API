package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponseDto extends RepresentationModel<EnderecoResponseDto> {
    String rua;
    String numero;
    String bairro;
    String complemento;
    String cidade;
    String uf;
}
