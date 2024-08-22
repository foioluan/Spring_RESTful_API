package com.example.demo.controller;

import com.example.demo.domain.Endereco;
import com.example.demo.dto.EnderecoRequestDto;
import com.example.demo.dto.EnderecoResponseDto;
import com.example.demo.service.EnderecoService;
import com.example.demo.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/usuarios/enderecos/")
@AllArgsConstructor
public class EnderecoController {

    private final UsuarioService usuarioService;
    private final EnderecoService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<EnderecoResponseDto> create(@RequestBody EnderecoRequestDto enderecoDto){
        Endereco created = service.create(convertToEntity(enderecoDto));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping
    public Page<EnderecoResponseDto> listEnderecos(Pageable pageable){
        Page<Endereco> page = service.listAllEnderecos(pageable);

        return page.map(this::convertToDto);
    }

    private EnderecoResponseDto convertToDto(Endereco endereco){
        EnderecoResponseDto enderecoDto = mapper.map(endereco, EnderecoResponseDto.class);
        enderecoDto.addLinks(endereco);

        return enderecoDto;
    }

    private Endereco convertToEntity(EnderecoRequestDto enderecoDto){
        Endereco endereco = mapper.map(enderecoDto, Endereco.class);
        endereco.setUsuario(usuarioService.findById(enderecoDto.getId_usuario()));

        return endereco;
    }
}
