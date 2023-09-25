package br.com.guedes.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guedes.security.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {  
  Optional<User> findByEmail(String email);
}
