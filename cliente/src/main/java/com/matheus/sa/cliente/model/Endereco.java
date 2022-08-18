package com.matheus.sa.cliente.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Endereco {

    @Id
    private String id;
    private String cep;
    private String lagradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private Long numero;


}
