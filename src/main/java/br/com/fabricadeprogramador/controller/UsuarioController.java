package br.com.fabricadeprogramador.controller;

import br.com.fabricadeprogramador.model.Usuario;

import java.util.List;

import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/protected/usucontroller")
@CrossOrigin(origins = {"*"} )
public class UsuarioController {
	
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public Usuario inserir(@RequestBody Usuario usuario) throws ServiceException{
        return usuarioService.salvar(usuario);
    }

    @PutMapping
    public Usuario alterar(@RequestBody Usuario usuario) throws ServiceException{
    	return usuarioService.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Integer id){
        usuarioService.excluir(id);
    }

    @GetMapping
    public List<Usuario> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable("id") Integer id){
        return usuarioService.buscarPorId(id);
    }

}
