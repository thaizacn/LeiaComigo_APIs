package br.com.tcn.leiacomigo.controller;

import br.com.tcn.leiacomigo.dto.UsuarioDTO;
import br.com.tcn.leiacomigo.dto.UsuarioReturnDTO;
import br.com.tcn.leiacomigo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.tcn.leiacomigo.entity.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioReturnDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuario) {
        return  ResponseEntity.ok(usuarioService.cadastrarUsuario(usuario));
    }

    @GetMapping("/entrar")
    public void entrarUsuario(@RequestParam String nomeUsuario, @RequestParam String senha) {
        usuarioService.entrarUsuario(nomeUsuario, senha);
    }

    @GetMapping("/perfil")
    public ResponseEntity<Usuario> informacoesPerfilUsuario(@RequestParam String nomeUsuario){
       return ResponseEntity.ok(usuarioService.informacoesPerfilUsuario(nomeUsuario));
    }

    @PutMapping("/perfil")
    public void editarInformacoesPerfilUsuario(@RequestBody Usuario usuario){
        //TODO: Elaborar edição
    }
}
