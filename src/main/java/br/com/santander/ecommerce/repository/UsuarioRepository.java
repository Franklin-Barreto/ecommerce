package br.com.santander.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.ecommerce.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
