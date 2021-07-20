package br.com.santander.ecommerce.service;

import java.util.List;

import br.com.santander.ecommerce.model.Produto;

public interface ProdutoService {

	Produto buscarPorId(Integer id);

	List<Produto> buscarTodos();

	Produto salvar(Produto produto);

	void remover(Integer id);

	List<Produto> buscarPorCategoriaId(Integer id);
}
