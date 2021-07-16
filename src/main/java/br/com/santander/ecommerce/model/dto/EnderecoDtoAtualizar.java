package br.com.santander.ecommerce.model.dto;

public class EnderecoDtoAtualizar {

	private String rua;
	private String numero;
	private String cidade;

	public EnderecoDtoAtualizar(String rua, String numero, String cidade) {
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
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

}
