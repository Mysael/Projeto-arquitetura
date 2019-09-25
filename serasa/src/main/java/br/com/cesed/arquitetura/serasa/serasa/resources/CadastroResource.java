package br.com.cesed.arquitetura.serasa.serasa.resources;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cesed.arquitetura.serasa.serasa.domain.Cadastro;
import br.com.cesed.arquitetura.serasa.serasa.services.CadastroService;


@RestController
@RequestMapping(value="/cadastro")
public class CadastroResource {
	@Autowired
	private CadastroService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cadastro> find(@PathVariable Integer id) { // essa anotação PathVariable para que o spring saiba que o ID da url vai vir para o ID da variavel
		Cadastro obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Cadastro obj1){ //O RequestBody serve para garantir que esse meu objeto Cadastro vai ser construido a partir dos dados Json
		Cadastro obj = service.insert(obj1);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Cadastro obj1, @PathVariable Integer id){
		Cadastro obj = service.insert(obj1);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cadastro>> findAll() {
		List<Cadastro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
