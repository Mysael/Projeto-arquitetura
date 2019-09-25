package br.com.cesed.arquitetura.serasa.serasa.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cesed.arquitetura.serasa.serasa.domain.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer>{
	
}
