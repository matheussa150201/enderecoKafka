package com.matheus.sa.cliente.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheus.sa.cliente.model.Endereco;
import com.matheus.sa.cliente.service.EnderecoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EnderecoCliente {

    @Autowired
    private EnderecoService enderecoService;

    @KafkaListener(topics = "${topic.endereco-client}", groupId = "${spring.kafka.consumer.group-id}")
    public void obterEnderecoCliente(String enderecoString) throws JsonProcessingException {


        log.info("Mensagem Endereco {}", enderecoString);

        ObjectMapper objectMapper = new ObjectMapper();
        Endereco endereco = objectMapper.readValue(enderecoString, Endereco.class);

        enderecoService.save(endereco);
        log.info("Endereco salvo na base com sucesso: {}", endereco);

    }
}
