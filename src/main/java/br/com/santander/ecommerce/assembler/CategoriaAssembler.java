package br.com.santander.ecommerce.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
		categoriaDto.add(linkTo(methodOn(CategoriaController.class).buscarPorId(categoria.getId())).withSelfRel());
		categoriaDto.add(linkTo(methodOn(CategoriaController.class).listarTodos()).withRel("categorias"));
		return categoriaDto;
	}

}
