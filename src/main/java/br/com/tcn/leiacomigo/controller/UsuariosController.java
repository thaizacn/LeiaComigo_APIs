package br.com.tcn.leiacomigo.controller;

import br.com.tcn.leiacomigo.dto.UsuarioReturnDTO;
import br.com.tcn.leiacomigo.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.tcn.leiacomigo.dto.UsuarioDTO;
import br.com.tcn.leiacomigo.repository.UsuariosRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioReturnDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuario) {
        return  ResponseEntity.ok(usuariosService.cadastrarUsuario(usuario));
    }

    @PostMapping("/entrar")
    public void entrarUsuario(@RequestBody UsuarioDTO usuario) {
        usuariosService.entrarUsuario(usuario);
    }

    @GetMapping("/perfil")
    public ResponseEntity<UsuarioDTO> informacoesPerfilUsuario(@RequestParam String nomeUsuario){
       return ResponseEntity.ok(usuariosService.informacoesPerfilUsuario(nomeUsuario));
    }

    @PutMapping("/perfil")
    public void editarInformacoesPerfilUsuario(@RequestBody UsuarioDTO usuario){
        //TODO: Elaborar edição
    }
}
