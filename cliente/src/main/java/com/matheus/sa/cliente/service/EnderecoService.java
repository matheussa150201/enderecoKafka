package com.matheus.sa.cliente.service;

import com.matheus.sa.cliente.model.Endereco;
import com.matheus.sa.cliente.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco save(Endereco endereco){
        enderecoRepository.save(endereco);
        return endereco;
    }

    public List<Endereco> getListaEndereco(){
        return enderecoRepository.findAll();
    }
}
