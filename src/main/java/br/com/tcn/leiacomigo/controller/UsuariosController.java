package br.com.tcn.leiacomigo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcn.leiacomigo.dto.UsuarioDTO;
import br.com.tcn.leiacomigo.repository.UsuariosRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

	private final UsuariosRepository usuariosRepository;

	public UsuariosController(UsuariosRepository usuariosRepository) {
	    this.usuariosRepository = usuariosRepository;
	}


    @PostMapping("/registrar")
    public ResponseEntity<String> registerUser(@RequestBody UsuarioDTO usuario) {
        // Verifica se o usuário já está cadastrado
        if (usuariosRepository.existsByNomeUsuario(usuario.getNomeUsuario())) {
            return ResponseEntity.badRequest().body("Nome de usuário já existe");
        }
        // Salva o usuário no banco de dados
        usuariosRepository.save(usuario); 
        return ResponseEntity.ok("Cadastro realizado com sucesso");
    }

    @PostMapping("/entrar")
    public ResponseEntity<String> loginUser(@RequestBody UsuarioDTO usuario) {
        // Verifica se o usuário existe
        if (!usuariosRepository.existsByNomeUsuario(usuario.getNomeUsuario())) {
            return ResponseEntity.badRequest().body("Nome de usuário inválido");
        }
        // Verifica se a senha está correta
        UsuarioDTO existingUser = usuariosRepository.findByNomeUsuario(usuario.getNomeUsuario());
        if (!existingUser.getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.badRequest().body("Senha incorreta");
        }
        
        return ResponseEntity.ok("Login realizado com sucesso");
    }
}
