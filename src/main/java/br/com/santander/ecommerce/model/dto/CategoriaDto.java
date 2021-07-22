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

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public static CategoriaDto converte(Categoria categoria) {
		return new CategoriaDto(categoria.getId(), categoria.getNome());
	}

}
