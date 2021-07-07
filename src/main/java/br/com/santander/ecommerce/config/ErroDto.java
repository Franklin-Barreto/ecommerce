package br.com.santander.ecommerce.config;

public class ErroDto {

	private String campo;
	private String mensagem;

	public ErroDto(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
}
