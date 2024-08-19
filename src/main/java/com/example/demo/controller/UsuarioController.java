package com.example.demo.controller;

import com.example.demo.domain.Endereco;
import com.example.demo.domain.PerfilUsuario;
import com.example.demo.domain.Usuario;
import com.example.demo.dto.UsuarioRequestDto;
import com.example.demo.dto.UsuarioResponseDto;
import com.example.demo.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/usuarios/")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<UsuarioResponseDto> listAll(){
        return service.listAll().stream().map(this::convertToDto).collect(toList());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioRequestDto userDto){
        Usuario created = service.create(convertToEntity(userDto));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable("id") Long id){
        Usuario usuario = service.findById(id);
        UsuarioResponseDto usuarioDto = mapper.map(usuario, UsuarioResponseDto.class);

        return ResponseEntity.ok(usuarioDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioResponseDto> update(@PathVariable("id") Long id, @RequestBody UsuarioRequestDto userDto){
        try {
            Usuario usuario = service.findById(id);
        } catch (Exception e) {
            return this.create(userDto);
        }

        Usuario updated = service.update(mapper.map(userDto, Usuario.class), id);
        return ResponseEntity.ok(convertToDto(updated));
    }


    private UsuarioResponseDto convertToDto(Usuario user){
        UsuarioResponseDto usuarioDto = mapper.map(user, UsuarioResponseDto.class);
        usuarioDto.addLinks(user);

        return usuarioDto;
    }

    private Usuario convertToEntity(UsuarioRequestDto userDto){
        Usuario usuario = mapper.map(userDto, Usuario.class);
        PerfilUsuario perfilUsuario = mapper.map(userDto.getPerfilUsuario(), PerfilUsuario.class);
        List<Endereco> enderecos = userDto.getEnderecos().stream()
                        .map(dto -> mapper.map(dto, Endereco.class))
                        .collect(Collectors.toList());

        usuario.setPerfilUsuario(perfilUsuario);
        usuario.setEnderecos(enderecos);

        return usuario;
    }
}
