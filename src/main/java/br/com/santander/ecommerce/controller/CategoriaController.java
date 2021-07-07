package br.com.santander.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ecommerce.model.Categoria;
import br.com.santander.ecommerce.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	public Categoria salvar(@RequestBody @Valid Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		categoriaRepository.deleteById(id);
	}

	@GetMapping
	public List<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Categoria buscarPorId(@PathVariable Integer id) {
		/*Optional<Categoria> optional = categoriaRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new RuntimeException("Não existe recurso com esse id");*/
		
		//return categoriaRepository.findById(id).orElseThrow(()-> new RuntimeException("Não existe recurso com esse id") );
		return categoriaRepository.getOne(id);
	}

}
