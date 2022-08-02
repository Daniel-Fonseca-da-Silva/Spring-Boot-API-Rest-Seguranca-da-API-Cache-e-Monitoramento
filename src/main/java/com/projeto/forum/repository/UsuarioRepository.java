package com.projeto.forum.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.forum.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);
	
}
