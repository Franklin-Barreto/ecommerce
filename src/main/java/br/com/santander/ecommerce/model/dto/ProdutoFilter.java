package br.com.santander.ecommerce.model.dto;

public class ProdutoFilter {

	String nome;
	Double preco;

	public ProdutoFilter(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}
}
