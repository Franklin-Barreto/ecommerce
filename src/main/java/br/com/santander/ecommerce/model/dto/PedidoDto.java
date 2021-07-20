package br.com.santander.ecommerce.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.santander.ecommerce.model.Pedido;

public class PedidoDto {

	private Integer id;
	private String clienteNome;
	private List<ItemPedidoDto> itens = new ArrayList<>();
	private LocalDate dataCompra;
	private BigDecimal valorTotal;

	public PedidoDto(Integer id, String clienteNome, List<ItemPedidoDto> itens, LocalDate dataCompra,
			BigDecimal valorTotal) {
		this.id = id;
		this.clienteNome = clienteNome;
		this.itens = itens;
		this.dataCompra = dataCompra;
		this.valorTotal = valorTotal;
	}

	public Integer getId() {
		return id;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public List<ItemPedidoDto> getItens() {
		return itens;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public static PedidoDto converte(Pedido pedido) {
		return new PedidoDto(pedido.getId(), pedido.getCliente().getNome(),
				pedido.getItens().stream()
						.map(ItemPedidoDto::converte)
						.collect(Collectors.toList()),
				pedido.getDataCriacao(), pedido.getValorTotal());
	}

}
