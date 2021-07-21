package br.com.santander.ecommerce.service;

import java.util.List;

import br.com.santander.ecommerce.model.Categoria;

public interface CategoriaService {

	Categoria salvar(Categoria categoria);

	List<Categoria> buscarTodos();

	Categoria buscarPorId(Integer id);

	void excluir(Integer id);

}
