package br.com.tcn.leiacomigo.mapper;

import br.com.tcn.leiacomigo.dto.UsuarioDTO;
import br.com.tcn.leiacomigo.entity.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNomeCompleto(usuarioDTO.getNomeCompleto());
        usuario.setNomeUsuario(usuarioDTO.getNomeUsuario());
        usuario.setSenha(usuarioDTO.getSenha()); // TODO: Encriptar senha
        usuario.setDataDeNascimento(usuarioDTO.getDataDeNascimento());
        return usuario;
    }
}