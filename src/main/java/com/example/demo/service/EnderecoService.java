package com.example.demo.service;

import com.example.demo.domain.Endereco;
import com.example.demo.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends GenericService<Endereco, Long, EnderecoRepository> {
    public EnderecoService(EnderecoRepository repository) {
        super(repository);
    }
}
