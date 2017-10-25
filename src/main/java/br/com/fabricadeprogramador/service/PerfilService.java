package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.model.Perfil;
import br.com.fabricadeprogramador.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by viniciuspodi on 20/10/17.
 */
@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    public Perfil salvar(Perfil perfil){
        return perfilRepository.save(perfil);
    }

    public void excluir(Integer id){
        perfilRepository.delete(id);
    }

    public List<Perfil> buscarTodos(){
        return perfilRepository.findAll();
    }

    public Perfil buscarPorId(Integer id){
        return perfilRepository.findOne(id);
    }

}
