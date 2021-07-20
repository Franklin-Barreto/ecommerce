package br.com.santander.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.santander.ecommerce.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	List<Pedido> findAllByClienteId(Integer clienteId);
}
