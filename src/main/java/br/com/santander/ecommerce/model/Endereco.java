package br.com.santander.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rua;
	private String numero;
	private String cidade;
	@ManyToOne
	private Usuario usuario;

	public Endereco(String rua, String numero, String cidade) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}
	
	protected Endereco() {}

	public Integer getId() {
		return id;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
