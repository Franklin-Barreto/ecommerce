package br.com.santander.ecommerce.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.santander.ecommerce.model.Cliente;
import br.com.santander.ecommerce.model.ItemPedido;
import br.com.santander.ecommerce.model.Pedido;
import br.com.santander.ecommerce.model.dto.ItemPedidoDto;
import br.com.santander.ecommerce.model.dto.PedidoDto;
import br.com.santander.ecommerce.model.dto.PedidoDtoInput;
import br.com.santander.ecommerce.repository.ClienteRepository;
import br.com.santander.ecommerce.repository.ItemPedidoRepository;
import br.com.santander.ecommerce.repository.PedidoRepository;
import br.com.santander.ecommerce.repository.ProdutoRepository;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

	private PedidoRepository pedidoRepository;
	private ClienteRepository clienteRepository;
	private ProdutoRepository produtoRepository;
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	public PedidoController(PedidoRepository pedidoRepository, ClienteRepository clienteRepository,
			ProdutoRepository produtoRepository,ItemPedidoRepository itemPedidoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.clienteRepository = clienteRepository;
		this.produtoRepository = produtoRepository;
		this.itemPedidoRepository = itemPedidoRepository;
	}

	@PostMapping
	public ResponseEntity<Pedido> salvar(@RequestBody @Valid PedidoDtoInput pedidoDto,
			UriComponentsBuilder uriBuilder) {

		Cliente cliente = clienteRepository.getOne(pedidoDto.getClienteId());

		Pedido pedido = new Pedido(cliente);
		List<ItemPedido> itens = pedidoDto.getItensPedidoInputDto().stream()
				.map(i -> new ItemPedido(produtoRepository.getOne(i.getProdutoId()), i.getQuantidade()))
				.collect(Collectors.toList());

		itens.forEach(item -> pedido.adicionaItem(item));

		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedidoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(pedidoSalvo);
	}

	@GetMapping
	public ResponseEntity<PedidoDto> buscarPorId(Integer clienteId) {
		Pedido pedido = pedidoRepository.findByClienteId(clienteId);
		//List<ItemPedido> itensPedido = itemPedidoRepository.findAllByPedidoId(pedido.getId());
		// era List<ItemPedidoDto> itensPedidoDto = itensPedido.stream()
		
		List<ItemPedidoDto> itensPedidoDto =		pedido.getItens().stream().map(i -> new ItemPedidoDto(i.getProduto().getNome(), i.getProduto().getPreco(), i.getQuantidade()))
				.collect(Collectors.toList());
		PedidoDto pedidoDto = new PedidoDto(pedido.getId(), pedido.getCliente().getNome(), itensPedidoDto,
				pedido.getDataCriacao(), pedido.getValorTotal());
		return ResponseEntity.ok(pedidoDto);
	}

}
