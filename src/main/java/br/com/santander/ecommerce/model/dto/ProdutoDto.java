package br.com.santander.ecommerce.model.dto;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import br.com.santander.ecommerce.model.Produto;

public class ProdutoDto extends RepresentationModel<ProdutoDto> {

	private Integer id;
	private String nome;
	private BigDecimal preco;
	private CategoriaDto categoria;

	public ProdutoDto(Integer id, String nome, BigDecimal preco, CategoriaDto categoria) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public CategoriaDto getCategoria() {
		return categoria;
	}

	public static ProdutoDto converte(Produto produto) {
		return new ProdutoDto(produto.getId(), produto.getNome(), produto.getPreco(),
				CategoriaDto.converte(produto.getCategoria()));
	}

}
