package br.com.tcn.leiacomigo.service;

import br.com.tcn.leiacomigo.dto.UsuarioDTO;
import br.com.tcn.leiacomigo.entity.Usuario;
import br.com.tcn.leiacomigo.dto.UsuarioReturnDTO;
import br.com.tcn.leiacomigo.exception.BadRequestException;
import br.com.tcn.leiacomigo.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioReturnDTO cadastrarUsuario(UsuarioDTO usuario){
        log.info("Requisição para cadastro de usuário recebida!");

        if (usuarioRepository.existsByNomeUsuario(usuario.getNomeUsuario())) {
            log.error("O nome de usuário já existe.");
            throw new BadRequestException("Nome de usuário já existe!");
        }

        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setNomeCompleto(usuario.getNomeCompleto());
        usuarioEntity.setNomeUsuario(usuario.getNomeUsuario());
        //TODO: Fazer encript da senha
        usuarioEntity.setSenha(usuario.getSenha());
        usuarioEntity.setDataDeNascimento(usuario.getDataDeNascimento());

        usuarioRepository.save(usuarioEntity);
        log.info("Processamento concluído com sucesso.");
        return UsuarioReturnDTO.builder().id(usuarioEntity.getIdUsuario()).build();
    }

    public void entrarUsuario(Usuario usuario){
        // Verifica se o usuário existe
        if (!usuarioRepository.existsByNomeUsuario(usuario.getNomeUsuario())) {
            throw new BadRequestException("Nome de usuário inválido");
        }
        // Verifica se a senha está correta
        Usuario existingUser = usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario());
        if (!existingUser.getSenha().equals(usuario.getSenha())) {
            throw new BadRequestException("Senha incorreta");
        }
    }

    public Usuario informacoesPerfilUsuario(String nomeUsuario){
        // Verifica se o usuário existe
        if (!usuarioRepository.existsByNomeUsuario(nomeUsuario)) {
            throw new BadRequestException("Nome de usuário inválido");
        }
        return usuarioRepository.findByNomeUsuario(nomeUsuario);
    }
}
