package br.com.santander.ecommerce.model.dto;

public class ParametrosBusca {

	private String operacao;
	private String campo;
	private Object valor;
	
	public ParametrosBusca(String operacao, String campo,Object valor) {
		this.operacao = operacao;
		this.campo = campo;
		this.valor= valor;
	}
	
	public String getOperacao() {
		return operacao;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public Object getValor() {
		return valor;
	}
	
	
}
