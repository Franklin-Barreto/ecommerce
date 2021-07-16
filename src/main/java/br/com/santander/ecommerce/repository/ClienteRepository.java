package br.com.santander.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente findByNome(String nome);
	

}
