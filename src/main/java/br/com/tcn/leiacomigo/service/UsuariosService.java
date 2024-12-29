package br.com.tcn.leiacomigo.service;

import br.com.tcn.leiacomigo.dto.UsuarioDTO;
import br.com.tcn.leiacomigo.dto.UsuarioReturnDTO;
import br.com.tcn.leiacomigo.exception.BadRequestException;
import br.com.tcn.leiacomigo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public UsuarioReturnDTO cadastrarUsuario(UsuarioDTO usuario){
        // Verifica se o usuário já está cadastrado
        if (usuariosRepository.existsByNomeUsuario(usuario.getNomeUsuario())) {
            throw new BadRequestException("Nome de usuário já existe!");
        }
        // Salva o usuário no banco de dados
        usuariosRepository.save(usuario);

        return UsuarioReturnDTO.builder().id(usuario.getId()).build();
    }

    public void entrarUsuario(UsuarioDTO usuario){
        // Verifica se o usuário existe
        if (!usuariosRepository.existsByNomeUsuario(usuario.getNomeUsuario())) {
            throw new BadRequestException("Nome de usuário inválido");
        }
        // Verifica se a senha está correta
        UsuarioDTO existingUser = usuariosRepository.findByNomeUsuario(usuario.getNomeUsuario());
        if (!existingUser.getSenha().equals(usuario.getSenha())) {
            throw new BadRequestException("Senha incorreta");
        }
    }

    public UsuarioDTO informacoesPerfilUsuario(String nomeUsuario){
        // Verifica se o usuário existe
        if (!usuariosRepository.existsByNomeUsuario(nomeUsuario)) {
            throw new BadRequestException("Nome de usuário inválido");
        }
        return usuariosRepository.findByNomeUsuario(nomeUsuario);
    }
}
