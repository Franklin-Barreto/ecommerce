package br.com.santander.ecommerce.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.santander.ecommerce.model.Produto;
import br.com.santander.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Override
	public Produto buscarPorId(Integer id) {

		return produtoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Produto de id " + id + " não encontrado"));
	}

	@Override
	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto salvar(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Integer id) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Produto> buscarPorCategoriaId(Integer id) {
		return produtoRepository.findAllByCategoriaId(id);
	}

}
