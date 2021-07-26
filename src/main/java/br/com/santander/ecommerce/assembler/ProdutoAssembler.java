package br.com.santander.ecommerce.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.santander.ecommerce.controller.ProdutoController;
import br.com.santander.ecommerce.model.Produto;
import br.com.santander.ecommerce.model.dto.ProdutoDto;

@Component
public class ProdutoAssembler extends RepresentationModelAssemblerSupport<Produto, ProdutoDto> {

	private final CategoriaAssembler categoriaAssembler;

	public ProdutoAssembler(CategoriaAssembler categoriaAssembler) {
		super(ProdutoController.class, ProdutoDto.class);
		this.categoriaAssembler = categoriaAssembler;
	}

	@Override
	public ProdutoDto toModel(Produto produto) {
		ProdutoDto produtoDto = ProdutoDto.converte(produto);
		produtoDto.add(linkTo(methodOn(ProdutoController.class).buscarPorId(produto.getId())).withSelfRel());
		produtoDto.add(linkTo(methodOn(ProdutoController.class).buscarTodos()).withRel("produtos"));
		
		produtoDto.setCategoria(categoriaAssembler.toModel(produto.getCategoria()));
		return produtoDto;
	}
	
	@Override
	public CollectionModel<ProdutoDto> toCollectionModel(Iterable<? extends Produto> produtos) {
		return super.toCollectionModel(produtos);
	}
}
