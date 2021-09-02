package br.com.santander.ecommerce.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.santander.ecommerce.model.Produto;

public class ProdutoSpecification {

	public static Specification<Produto> porNome(String nome) {
		return (root, query, builder) -> nome != null ?  builder.like(root.get("nome"), "%" + nome + "%")
				: null;
	}

	public static Specification<Produto> porPreco(Double preco) {
		return (root, query, builder) -> preco != null ? builder.equal(root.get("preco"), preco)
				: null;
	}

}
