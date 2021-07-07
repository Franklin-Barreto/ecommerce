package br.com.santander.ecommerce.model.dto;

public class ItemPedidoInputDto {

	private int produtoId;
	private int quantidade;

	public ItemPedidoInputDto(int produtoId, int quantidade) {
		this.produtoId = produtoId;
		this.quantidade = quantidade;
	}

	public int getProdutoId() {
		return produtoId;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
