package br.com.santander.ecommerce.controller;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.model.Categoria;
import br.com.santander.ecommerce.model.Produto;
import br.com.santander.ecommerce.model.dto.ProdutoDto;
import br.com.santander.ecommerce.model.dto.ProdutoDtoInput;
import br.com.santander.ecommerce.repository.CategoriaRepository;
import br.com.santander.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	public Produto salvar(@RequestBody ProdutoDtoInput produtoDto) {
		Categoria categoria = categoriaRepository.getOne(produtoDto.getCategoriaId());
		Produto produto = new Produto(produtoDto.getNome(), produtoDto.getPreco(), categoria);
		return produtoService.salvar(produto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		ProdutoDto produtoDto = ProdutoDto.converte(produtoService.buscarPorId(id));
		Link self = linkTo(CategoriaController.class).slash(id).withSelfRel();
		Link categorias = linkTo(CategoriaController.class).withRel("categorias");
		produtoDto.getCategoria().add(self).add(categorias);
		produtoDto.add(linkTo(ProdutoController.class).slash(id).withSelfRel())
				.add(linkTo(ProdutoController.class).withRel("produtos"));
		return ResponseEntity.ok(produtoDto);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/categoria/{id}")
	public List<Produto> buscarPorCategoriaId(@PathVariable Integer id) {
		return produtoService.buscarPorCategoriaId(id);

	}

	@GetMapping
	public List<Produto> buscarTodos() {
		return produtoService.buscarTodos();
	}

}
