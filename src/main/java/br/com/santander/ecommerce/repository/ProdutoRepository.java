package br.com.santander.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.santander.ecommerce.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	@Query(value = "SELECT p FROM Produto p JOIN p.categoria c WHERE p.categoria.id = :id")
	List<Produto> findAllByCategoriaId(Integer id);
	
	@Query("SELECT p FROM Produto p JOIN FETCH p.categoria c")
	List<Produto> findAll();
}
