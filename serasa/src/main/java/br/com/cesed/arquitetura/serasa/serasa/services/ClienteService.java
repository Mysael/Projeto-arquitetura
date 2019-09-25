package br.com.cesed.arquitetura.serasa.serasa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesed.arquitetura.serasa.serasa.domain.Cliente;
import br.com.cesed.arquitetura.serasa.serasa.repositories.ClienteRepository;
import br.com.cesed.arquitetura.serasa.serasa.services.exception.DataIntegrityViolationException;
import br.com.cesed.arquitetura.serasa.serasa.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private CadastroService repo2;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado! Id: " + id + ",Tipo: " + Cliente.class.getName()));
	}
	public Cliente insert(Cliente obj) {
		if(repo2.findAll().contains(obj.getCpf())) {
			obj.setId(null);
			return repo.save(obj);
		}
		return null;
		
	}
	
	/*public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}*/
	/*public void insert(Cliente obj) {
		if(repo2.findAll().contains(obj.getCpf())) {
			System.out.println("CPF na Serasa, vai pagar a conta!!!");
		}else {
			obj.setId(null);
			repo.save(obj);
		}	
	}*/
	public Cliente update(Cliente obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir Esse Cliente");
		}	
	}
	public List<Cliente> findAll(){
		return repo.findAll();
	}

}
