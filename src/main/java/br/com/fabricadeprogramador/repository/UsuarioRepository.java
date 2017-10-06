package br.com.fabricadeprogramador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fabricadeprogramador.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findByNomeIgnoreCase(String nome);

    List<Usuario> findByNomeAndSenha(String nome, String senha);
    
    List<Usuario> findByPerfilDescricao(String descricao);

    List<Usuario> buscarPorPerfil(String descricaoPerfil );
    
    @Query("select new Usuario(u.id,u.nome, u.email) from Usuario u where u.perfil.id=?1")
    List<Usuario> findByPerfilId(Integer id);
}
