package com.matheus.endereco.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@Configuration
public class CepFeingConfig {

    @Value("{api.cep.username}")
    private String usuario;

    @Value("api.cep.senha")
    private String senha;


    private BasicAuthenticationInterceptor basicAuthenticationInterceptor;

    @Bean
    public BasicAuthenticationInterceptor basicAuthenticationInterceptor(){
        return new BasicAuthenticationInterceptor(usuario,senha);
    }
}
