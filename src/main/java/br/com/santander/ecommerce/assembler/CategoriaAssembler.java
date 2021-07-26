package br.com.santander.ecommerce.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.santander.ecommerce.controller.CategoriaController;
import br.com.santander.ecommerce.model.Categoria;
import br.com.santander.ecommerce.model.dto.CategoriaDto;

@Component
public class CategoriaAssembler extends RepresentationModelAssemblerSupport<Categoria, CategoriaDto> {

	public CategoriaAssembler() {
		super(CategoriaController.class, CategoriaDto.class);
	}

	@Override
	public CategoriaDto toModel(Categoria categoria) {
		CategoriaDto categoriaDto = CategoriaDto.converte(categoria);
		categoriaDto.add(getLinkCategoriaId(categoria.getId()));
		categoriaDto.add(getLinkCategorias());
		return categoriaDto;
	}

	@Override
	public CollectionModel<CategoriaDto> toCollectionModel(Iterable<? extends Categoria> entities) {
		return super.toCollectionModel(entities).add(getLinkCategorias());
	}

	private Link getLinkCategorias() {
		return linkTo(methodOn(CategoriaController.class).listarTodos()).withRel("categorias");
	}

	private Link getLinkCategoriaId(Integer id) {
		return linkTo(methodOn(CategoriaController.class).buscarPorId(id)).withSelfRel();
	}

}
