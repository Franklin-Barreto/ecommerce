package br.com.santander.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.model.Categoria;
import br.com.santander.ecommerce.model.Produto;
import br.com.santander.ecommerce.model.dto.ProdutoDtoInput;
import br.com.santander.ecommerce.repository.CategoriaRepository;
import br.com.santander.ecommerce.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	public Produto salvar(@RequestBody ProdutoDtoInput produtoDto) {
		Categoria categoria = categoriaRepository.getOne(produtoDto.getCategoriaId());
		Produto produto = new Produto(produtoDto.getNome(), produtoDto.getPreco(), categoria);
		return produtoRepository.save(produto);
	}
}
