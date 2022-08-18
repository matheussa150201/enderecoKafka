package com.matheus.endereco.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheus.endereco.http.EnderecoJson;
import com.matheus.endereco.response.EnderecoResponse;
import com.matheus.endereco.service.EnderecoService;
import com.matheus.endereco.service.ViaCepService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("endereco")
@RestController
@Log4j2
public class EnderecoController {

    @Autowired
    private ViaCepService cepService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{endereco}")
    public ResponseEntity<EnderecoResponse> obterEndereco(@PathVariable("endereco") String cep){
        EnderecoResponse enderecoResponse = cepService.obterCep(cep);
        return ResponseEntity.ok(enderecoResponse);
    }

    @PostMapping
    public ResponseEntity<EnderecoResponse> enviarEndereco(@RequestBody EnderecoJson enderecoJson) throws JsonProcessingException {
        log.info("## Dados enviados pelo cliente: {}", enderecoJson);

        EnderecoResponse enderecoResponse = cepService.obterCep(enderecoJson.getCep());
        enderecoResponse.setComplemento(enderecoJson.getComplemento());
        enderecoResponse.setNumero(enderecoJson.getNumero());

        ObjectMapper objectMapper = new ObjectMapper();
        String mensagem = objectMapper.writeValueAsString(enderecoResponse);

        enderecoService.sendMessage(mensagem);
        log.info("## Endereco retornado pela API de Cep: {}", enderecoResponse);

        return ResponseEntity.ok(enderecoResponse);
    }
}
