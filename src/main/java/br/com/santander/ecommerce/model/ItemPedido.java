package br.com.santander.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "preco")
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "produto_fk")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "pedido_fk")
	@JsonIgnore
	private Pedido pedido;
	private int quantidade;

	@Transient
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;

	public ItemPedido(Produto produto, int quantidade) {
		this.valor = produto.getPreco();
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorTotal = valor.multiply(BigDecimal.valueOf(quantidade));
	}

	public ItemPedido() {
	}

	public Integer getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
