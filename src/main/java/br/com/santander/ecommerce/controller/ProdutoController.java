package br.com.santander.ecommerce.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.assembler.ProdutoAssembler;
import br.com.santander.ecommerce.model.Categoria;
import br.com.santander.ecommerce.model.Produto;
import br.com.santander.ecommerce.model.dto.ProdutoDto;
import br.com.santander.ecommerce.model.dto.ProdutoDtoInput;
import br.com.santander.ecommerce.repository.CategoriaRepository;
import br.com.santander.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private ProdutoService produtoService;
	private CategoriaRepository categoriaRepository;
	private final ProdutoAssembler produtoAssembler;

	public ProdutoController(ProdutoService produtoService, CategoriaRepository categoriaRepository,
			ProdutoAssembler produtoAssembler) {
		this.produtoService = produtoService;
		this.categoriaRepository = categoriaRepository;
		this.produtoAssembler = produtoAssembler;
	}

	@PostMapping
	public Produto salvar(@RequestBody ProdutoDtoInput produtoDto) {
		Categoria categoria = categoriaRepository.getOne(produtoDto.getCategoriaId());
		Produto produto = new Produto(produtoDto.getNome(), produtoDto.getPreco(), categoria);
		return produtoService.salvar(produto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable Integer id) {
		ProdutoDto produtoDto = produtoAssembler.toModel(produtoService.buscarPorId(id));
		return ResponseEntity.ok(produtoDto);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/categoria/{id}")
	public List<Produto> buscarPorCategoriaId(@PathVariable Integer id) {
		return produtoService.buscarPorCategoriaId(id);

	}

	@GetMapping
	public ResponseEntity<CollectionModel<ProdutoDto>> buscarTodos() {
	/*	List<ProdutoDto> produtos = produtoService.buscarTodos().stream().map(p -> {
			Link selfProduto = linkTo(methodOn(ProdutoController.class).buscarPorId(p.getId())).withSelfRel();

			Link selfCategoria = linkTo(CategoriaController.class).slash(p.getCategoria().getId()).withSelfRel();
			ProdutoDto produtoDto = ProdutoDto.converte(p).add(selfProduto);
			produtoDto.getCategoria().add(selfCategoria);
			return produtoDto;
		}).collect(Collectors.toList());

		return ResponseEntity.ok(RepresentationModel.of(produtos).add(linkTo(ProdutoController.class).withSelfRel()));*/
		return ResponseEntity.ok(produtoAssembler.toCollectionModel(produtoService.buscarTodos()));
	}
}
