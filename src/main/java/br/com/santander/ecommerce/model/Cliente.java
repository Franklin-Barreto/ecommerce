package br.com.santander.ecommerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();

	public Cliente(String nome, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	protected Cliente() {
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		enderecos.forEach(e -> adicionaEndereco(e));
	}

	public void adicionaEndereco(Endereco endereco) {
		endereco.setCliente(this);
		this.enderecos.add(endereco);
	}

	public List<Endereco> getEnderecos() {
		return Collections.unmodifiableList(enderecos);
	}

}
