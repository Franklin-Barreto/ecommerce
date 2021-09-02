package br.com.santander.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Perfil implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	public Perfil(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	protected Perfil() {
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String getAuthority() {
		return nome;
	}

}
