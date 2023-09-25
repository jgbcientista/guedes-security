package br.com.guedes.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guedes.security.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {  
  
	Optional<Usuario> findByLogin(String login);
}
