package br.com.tcn.leiacomigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcn.leiacomigo.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	boolean existsByNomeUsuario(String nomeUsuario);
    Usuario findByNomeUsuario(String nomeUsuario);
}
