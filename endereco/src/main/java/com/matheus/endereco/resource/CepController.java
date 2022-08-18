package com.matheus.endereco.resource;

import com.matheus.endereco.response.EnderecoResponse;
import com.matheus.endereco.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("cep")
public class CepController {

    @Autowired
    private ViaCepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoResponse> obterCep(@PathVariable("cep") String cep){
        EnderecoResponse enderecoResponse = cepService.obterCep(cep);
        return ResponseEntity.ok(enderecoResponse);
    }
}
