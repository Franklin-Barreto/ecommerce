package br.com.santander.ecommerce.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.santander.ecommerce.model.ItemPedido;
import br.com.santander.ecommerce.model.Pedido;
import br.com.santander.ecommerce.model.Usuario;
import br.com.santander.ecommerce.model.dto.PedidoDto;
import br.com.santander.ecommerce.model.dto.PedidoDtoInput;
import br.com.santander.ecommerce.repository.ItemPedidoRepository;
import br.com.santander.ecommerce.repository.PedidoRepository;
import br.com.santander.ecommerce.repository.UsuarioRepository;
import br.com.santander.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

	private PedidoRepository pedidoRepository;
	private UsuarioRepository clienteRepository;
	private ProdutoService produtoService;

	@Autowired
	public PedidoController(PedidoRepository pedidoRepository, UsuarioRepository clienteRepository,
			ProdutoService produtoService, ItemPedidoRepository itemPedidoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.clienteRepository = clienteRepository;
		this.produtoService = produtoService;
	}

	@PostMapping
	public ResponseEntity<Pedido> salvar(@RequestBody @Valid PedidoDtoInput pedidoDto,
			UriComponentsBuilder uriBuilder) {

		Usuario cliente = clienteRepository.getOne(pedidoDto.getClienteId());

		Pedido pedido = new Pedido(cliente);
		List<ItemPedido> itens = pedidoDto.getItensPedidoInputDto().stream()
				.map(i -> new ItemPedido(produtoService.buscarPorId(i.getProdutoId()), i.getQuantidade()))
				.collect(Collectors.toList());

		itens.forEach(item -> pedido.adicionaItem(item));

		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedidoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(pedidoSalvo);
	}

	@GetMapping("/cliente/{clienteId}")
	public ResponseEntity<List<PedidoDto>> buscarPorIdCliente(@PathVariable Integer clienteId) {
		List<PedidoDto> pedidos = pedidoRepository.findAllByClienteId(clienteId).stream().map(PedidoDto::converte)
				.collect(Collectors.toList());
		return ResponseEntity.ok(pedidos);
	}

	@GetMapping("/{id}")
	public Pedido buscarPorId(@PathVariable Integer id) {
		return pedidoRepository.getOne(id);
	}

}
