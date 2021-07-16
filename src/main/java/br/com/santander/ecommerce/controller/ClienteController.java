package br.com.santander.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.model.Cliente;
import br.com.santander.ecommerce.model.dto.ClienteInputDto;
import br.com.santander.ecommerce.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente salvar(@RequestBody ClienteInputDto clienteDto) {
		Cliente cliente = clienteDto.converte();
		return clienteRepository.save(cliente);
	}
	
	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable Integer id) {
		
	//	Optional<Cliente> optional = clienteRepository.findById(id);
		/*
		if(optional.isPresent()) {
			return optional.get(); 
		}
		throw new RuntimeException("Não existe");*/
		//return new Cliente(null, null, null);
		// return clienteRepository.findById(id).orElse(new Cliente(null, null, null));
		//clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("Não existe"));
		return clienteRepository.getOne(id);
	}
	
	@GetMapping
	public Cliente buscarPorNome(String nome) {
		return clienteRepository.findByNome(nome);
	}
}
