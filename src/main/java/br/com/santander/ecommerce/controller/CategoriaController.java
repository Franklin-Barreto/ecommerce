package br.com.santander.ecommerce.controller;

import javax.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.model.Categoria;
import br.com.santander.ecommerce.model.dto.CategoriaDto;
import br.com.santander.ecommerce.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
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
	public ResponseEntity<?> listarTodos() {

		Link self = Link.of("http://localhost:8080/categorias");
		return ResponseEntity.ok(RepresentationModel.of(categoriaService.buscarTodos()).add(self));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		CategoriaDto categoriaDto = CategoriaDto.converte(categoriaService.buscarPorId(id));
		Link self = linkTo(CategoriaController.class).slash(id).withSelfRel();
		Link categorias = linkTo(CategoriaController.class).withRel("categorias");
		return ResponseEntity.ok(categoriaDto.add(self).add(categorias));

	}

}
