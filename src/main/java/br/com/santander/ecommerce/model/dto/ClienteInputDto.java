package br.com.santander.ecommerce.model.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import br.com.santander.ecommerce.model.Endereco;
/*
public class ClienteInputDto {

	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Set<Endereco> enderecos = new HashSet<>();

	public ClienteInputDto(String nome, String cpf, LocalDate dataNascimento, Set<Endereco> enderecos) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
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

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public Cliente converte() {
		Cliente cliente = new Cliente(nome, cpf, dataNascimento);
		enderecos.forEach(e -> cliente.adicionaEndereco(e));
		return cliente;
	}

}
*/