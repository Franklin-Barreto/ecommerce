package br.com.santander.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.model.Cliente;
import br.com.santander.ecommerce.repository.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@GetMapping
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
}
