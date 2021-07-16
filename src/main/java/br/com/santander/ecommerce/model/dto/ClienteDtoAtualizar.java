package br.com.santander.ecommerce.model.dto;

import br.com.santander.ecommerce.model.Endereco;

public class ClienteDtoAtualizar {

	private String nome;
	private EnderecoDtoAtualizar endereco;

	public ClienteDtoAtualizar(String nome, EnderecoDtoAtualizar endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}

	public EnderecoDtoAtualizar getEnderecoDto() {
		return endereco;
	}
	
	public Endereco getEndereco(){
		return new Endereco(endereco.getRua(), endereco.getNumero(), endereco.getCidade());
	}

}
