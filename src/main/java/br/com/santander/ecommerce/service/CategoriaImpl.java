package br.com.santander.ecommerce.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.santander.ecommerce.model.Categoria;
import br.com.santander.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaImpl implements CategoriaService {

	private final CategoriaRepository categoriaRepository;

	public CategoriaImpl(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public Categoria salvar(Categoria categoria) {

		return this.categoriaRepository.save(categoria);
	}

	@Override
	public Categoria buscarPorId(Integer id) {
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Não existe categoria com o id " + id));
	}

	@Override
	public void excluir(Integer id) {
		categoriaRepository.deleteById(id);
	}

	@Override
	public List<Categoria> buscarTodos() {
		return this.categoriaRepository.findAll();
	}

}
