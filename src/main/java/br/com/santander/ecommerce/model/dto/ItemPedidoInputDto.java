package br.com.santander.ecommerce.model.dto;

import javax.validation.constraints.NotNull;

public class ItemPedidoInputDto {
	@NotNull
	private Integer produtoId;
	private int quantidade;

	public ItemPedidoInputDto(Integer produtoId, int quantidade) {
		this.produtoId = produtoId;
		this.quantidade = quantidade;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
