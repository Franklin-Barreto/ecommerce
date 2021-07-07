package br.com.santander.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.ecommerce.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
