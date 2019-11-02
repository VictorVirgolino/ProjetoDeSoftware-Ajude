package ajude.ajude.controllers;

import ajude.ajude.entities.Usuario;
import ajude.ajude.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController (UsuarioService usuarioService){
        super();
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(usuarioService.cadastrarUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return new ResponseEntity<List<Usuario>>(usuarioService.getUsuarios(), HttpStatus.OK);
    }

    @PutMapping("/usuarios")
    public ResponseEntity<Usuario> redefinirSenha(@RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(usuarioService.redefinirSenha(usuario.getEmail(), usuario.getSenha()), HttpStatus.OK);
    }
}
