package br.com.santander.ecommerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String senha;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Perfil> perfis = new HashSet<>();

	public Usuario(Integer id, String email, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.perfis = perfis;
	}
	
	protected Usuario() {
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

	public void setEnderecos(Collection<Endereco> enderecos) {
		enderecos.forEach(e -> adicionaEndereco(e));
	}

	public void adicionaEndereco(Endereco endereco) {
		endereco.setUsuario(this);
		this.enderecos.add(endereco);
	}

	public List<Endereco> getEnderecos() {
		return Collections.unmodifiableList(enderecos);
	}	

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return perfis;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
