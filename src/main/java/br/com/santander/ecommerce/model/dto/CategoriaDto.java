package br.com.santander.ecommerce.model.dto;

import org.springframework.hateoas.RepresentationModel;

import br.com.santander.ecommerce.model.Categoria;

public class CategoriaDto extends RepresentationModel<CategoriaDto> {

	private Integer id;
	private String nome;

	public CategoriaDto(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	protected CategoriaDto() {
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public static CategoriaDto converte(Categoria categoria) {
		return new CategoriaDto(categoria.getId(), categoria.getNome());
	}

}
