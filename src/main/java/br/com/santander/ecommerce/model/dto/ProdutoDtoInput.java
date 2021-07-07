package br.com.santander.ecommerce.model.dto;

import java.math.BigDecimal;

public class ProdutoDtoInput {

	private String nome;
	private BigDecimal preco;
	private Integer categoriaId;
	public ProdutoDtoInput(String nome,BigDecimal preco, Integer categoriaId) {
		this.nome = nome;
		this.categoriaId = categoriaId;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getCategoriaId() {
		return categoriaId;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	
}
