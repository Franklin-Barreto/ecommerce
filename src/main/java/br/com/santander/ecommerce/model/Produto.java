package br.com.santander.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private BigDecimal preco;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Produto(String nome, BigDecimal preco,Categoria categoria) {
		this.nome = nome;
		this.preco = preco;
		this.categoria =categoria;
	}
	
	public Produto() {
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
	
	public Categoria getCategoria() {
		return categoria;
	}

	
	
	

}
