package com.rubenfilipe07.gerenciadortarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "REST API Gerenciador de Tarefas", version = "1", description = "API do Gerenciador de Tarefas desenvolvido para o teste técnico da ESIG Group. [Veja no GitHub](https://github.com/RubenFilipe07/gerenciador-de-tarefas)"))
public class ApiGerenciadorTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGerenciadorTarefasApplication.class, args);
	}

}
