package br.com.tcn.leiacomigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcn.leiacomigo.dto.UsuarioDTO;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuarioDTO, Long> {
	
	boolean existsByNomeUsuario(String nomeUsuario);
    UsuarioDTO findByNomeUsuario(String nomeUsuario);

}
