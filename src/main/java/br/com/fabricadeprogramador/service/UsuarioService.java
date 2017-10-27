package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.model.Perfil;
import br.com.fabricadeprogramador.model.Usuario;
import br.com.fabricadeprogramador.repository.PerfilRepository;
import br.com.fabricadeprogramador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by viniciuspodi on 20/10/17.
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;

    public Usuario salvar(Usuario usuario) throws ServiceException{
        if(usuario.getPerfil() == null){
            Perfil perfilPadrao = perfilRepository.findOne(2);
            usuario.setPerfil(perfilPadrao);
        }

        if(usuario.getEmail().isEmpty() || usuario.getEmail() == null){
            throw new ServiceException("E-mail vazio!");
        }

        //TODO: Validar por email = Previnir email duplicado

        return usuarioRepository.save(usuario);
    }

    public void excluir(Integer id){
        usuarioRepository.delete(id);
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id){
        return usuarioRepository.findOne(id);
    }
    
    public List<Usuario> autenticar(Usuario usuario) {
    	return usuarioRepository.findByNomeAndSenha(usuario.getNome(), usuario.getSenha());
    }
}
