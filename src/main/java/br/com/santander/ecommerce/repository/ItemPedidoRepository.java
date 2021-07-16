package br.com.santander.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.ecommerce.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

	List<ItemPedido> findAllByPedidoId(Integer pedidoId);
}
