package com.matheus.sa.cliente.repository;

import com.matheus.sa.cliente.model.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String> {
    public Endereco save(Endereco endereco);
}
