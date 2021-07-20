package br.com.santander.ecommerce.controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.model.Categoria;
import br.com.santander.ecommerce.model.Produto;
import br.com.santander.ecommerce.model.dto.ProdutoDto;
import br.com.santander.ecommerce.model.dto.ProdutoDtoInput;
import br.com.santander.ecommerce.repository.CategoriaRepository;
import br.com.santander.ecommerce.repository.ProdutoRepository;
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
	//	Produto produto = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não existe produto com o id " + id));
		 return ResponseEntity.ok(produtoService.buscarPorId(id));
	}

}
