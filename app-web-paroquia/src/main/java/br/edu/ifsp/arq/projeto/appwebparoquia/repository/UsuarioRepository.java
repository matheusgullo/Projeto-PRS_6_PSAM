package br.edu.ifsp.arq.projeto.appwebparoquia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.projeto.appwebparoquia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByEmail(String email);
	
}
