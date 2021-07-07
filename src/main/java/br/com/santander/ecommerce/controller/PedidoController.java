package br.com.santander.ecommerce.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.model.Cliente;
import br.com.santander.ecommerce.model.ItemPedido;
import br.com.santander.ecommerce.model.Pedido;
import br.com.santander.ecommerce.model.dto.ItemPedidoInputDto;
import br.com.santander.ecommerce.model.dto.PedidoDtoInput;
import br.com.santander.ecommerce.repository.ClienteRepository;
import br.com.santander.ecommerce.repository.PedidoRepository;
import br.com.santander.ecommerce.repository.ProdutoRepository;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	public Pedido salvar(@RequestBody PedidoDtoInput pedidoInput) {

		Cliente cliente = clienteRepository.getOne(pedidoInput.getClienteId());
		Map<Integer, Integer> itemPedidoMap = pedidoInput.getItensPedidoInputDto().stream()
				.collect(Collectors.toMap(ItemPedidoInputDto::getProdutoId, ItemPedidoInputDto::getQuantidade));

		Pedido pedido = new Pedido(cliente);
		List<ItemPedido> itensPedido = produtoRepository.findAllById(itemPedidoMap.keySet()).stream()
				.map(p -> new ItemPedido(p, itemPedidoMap.get(p.getId()))).collect(Collectors.toList());
		itensPedido.stream().forEach(i -> pedido.adicionaItem(i));
		return pedidoRepository.save(pedido);
	}
}
