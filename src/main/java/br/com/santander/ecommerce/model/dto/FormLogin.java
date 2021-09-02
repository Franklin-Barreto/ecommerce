package br.com.santander.ecommerce.model.dto;

public class FormLogin {

	private String email;
	private String senha;

	public FormLogin(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

}
