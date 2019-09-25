package br.com.cesed.arquitetura.serasa.serasa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesed.arquitetura.serasa.serasa.domain.Cadastro;
import br.com.cesed.arquitetura.serasa.serasa.repositories.CadastroRepository;
import br.com.cesed.arquitetura.serasa.serasa.services.exception.DataIntegrityViolationException;
import br.com.cesed.arquitetura.serasa.serasa.services.exception.ObjectNotFoundException;

@Service
public class CadastroService {
	@Autowired
	private CadastroRepository repo;
	
	public Cadastro find(Integer id) {
		Optional<Cadastro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! Id: " + id + ",Tipo: " + Cadastro.class.getName()));
	}
	
	public Cadastro insert(Cadastro obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Cadastro update(Cadastro obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir Esse Cadastro");
		}	
	}
	public List<Cadastro> findAll(){
		return repo.findAll();
	}

}
