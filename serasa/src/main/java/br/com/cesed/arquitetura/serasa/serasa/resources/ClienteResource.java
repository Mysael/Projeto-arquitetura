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

import br.com.cesed.arquitetura.serasa.serasa.domain.Cliente;
import br.com.cesed.arquitetura.serasa.serasa.services.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {
	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) { // essa anotação PathVariable para que o spring saiba que o ID da url vai vir para o ID da variavel
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Cliente obj1){ //O RequestBody serve para garantir que esse meu objeto Cliente vai ser construido a partir dos dados Json
		//Cliente obj = service.insert(obj1);
		//obj = service.insert(obj);
		service.insert(obj1);//add
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj1.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Cliente obj1, @PathVariable Integer id){
		//Cliente obj = service.insert(obj1);
		//obj.setId(id);
		//obj = service.update(obj);
		service.update(obj1);//add
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
