package br.com.cesed.arquitetura.serasa.serasa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cesed.arquitetura.serasa.serasa.domain.Cadastro;
import br.com.cesed.arquitetura.serasa.serasa.domain.Cliente;
import br.com.cesed.arquitetura.serasa.serasa.repositories.CadastroRepository;
import br.com.cesed.arquitetura.serasa.serasa.repositories.ClienteRepository;

@SpringBootApplication
public class SerasaApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CadastroRepository cadastroRepository;

	public static void main(String[] args) {
		SpringApplication.run(SerasaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cadastro cad1 = new Cadastro(null, "Fulano", "123456");
		Cadastro cad2 = new Cadastro(null, "Cicrano", "654321");
		Cadastro cad3 = new Cadastro(null, "Beltrano", "987654");
		Cadastro cad4 = new Cadastro(null, "Eu", "456789");
		
		Cliente cli0 = new Cliente(null, "Tu", "654741");
		Cliente cli1 = new Cliente(null, "Ele", "963258");
		Cliente cli2 = new Cliente(null, "Nos", "741258");
		
		cadastroRepository.saveAll(Arrays.asList(cad1,cad2,cad3,cad4));
		clienteRepository.saveAll(Arrays.asList(cli0,cli1,cli2));
		
	}

}
