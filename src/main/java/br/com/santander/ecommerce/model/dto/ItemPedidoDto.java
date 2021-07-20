package br.com.santander.ecommerce.model.dto;

import java.math.BigDecimal;

import br.com.santander.ecommerce.model.ItemPedido;

public class ItemPedidoDto {

	private String produtoNome;
	private BigDecimal valor;
	private Integer quantidade;

	public ItemPedidoDto(String produtoNome, BigDecimal valor, Integer quantidade) {
		this.produtoNome = produtoNome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
	public static ItemPedidoDto converte(ItemPedido itemPedido) {
		return new ItemPedidoDto(itemPedido.getProduto().getNome(), itemPedido.getValor(), itemPedido.getQuantidade());
	}

}
