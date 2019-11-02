package ajude.ajude.services;

import ajude.ajude.daos.UsuarioRepository;
import ajude.ajude.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository<Usuario, String> usuarioDao;

    public UsuarioService(UsuarioRepository<Usuario, String> usuarioDao){
        super();
        this.usuarioDao = usuarioDao;
    }

    public Usuario cadastrarUsuario(Usuario usuario){

        Optional<Usuario> novoUsuario = findByEmail(usuario.getEmail());

        if(novoUsuario.isPresent()){
            return null;
        }

        return usuarioDao.save(usuario);
    }


    public List<Usuario> getUsuarios(){
        return usuarioDao.findAll();

    }

    public Usuario deletarUsuario(String email){

        Optional<Usuario> usuario = findByEmail(email);

        if(usuario.isPresent()){
            usuarioDao.delete(usuario.get());
            return usuario.get();
        }

        return null;

    }

    public Usuario redefinirSenha(String email,String novaSenha){
        Optional<Usuario> usuario = findByEmail(email);

        if(usuario.isPresent()){
            usuario.get().setSenha(novaSenha);
            usuarioDao.save(usuario.get());
            return usuario.get();
        }

        return null;

    }


    private Optional<Usuario> findByEmail(String email) {return usuarioDao.findById(email);}

}
