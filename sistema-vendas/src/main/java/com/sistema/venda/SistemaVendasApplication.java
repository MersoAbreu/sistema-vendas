package com.sistema.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sistema.venda.model.Cliente;
import com.sistema.venda.repository.ClienteRepository;

@SpringBootApplication
public class SistemaVendasApplication {
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository cliRepo) {
		return args->{
			Cliente cliente = Cliente.builder().cpf("35051020836").nome("Jose Da costa").build();
			cliRepo.save(cliente);
			
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(SistemaVendasApplication.class, args);
		
		
	}

}
