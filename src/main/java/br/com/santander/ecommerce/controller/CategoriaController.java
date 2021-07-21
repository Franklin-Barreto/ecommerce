package br.com.santander.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.model.Categoria;
import br.com.santander.ecommerce.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	private final CategoriaService categoriaService;
	
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping
	public Categoria salvar(@RequestBody @Valid Categoria categoria) {
		return categoriaService.salvar(categoria);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		categoriaService.excluir(id);
	}

	@GetMapping
	public List<Categoria> listarTodos() {
		return categoriaService.buscarTodos();
	}

	@GetMapping("/{id}")
	public Categoria buscarPorId(@PathVariable Integer id) {
		return categoriaService.buscarPorId(id);
	}

}
