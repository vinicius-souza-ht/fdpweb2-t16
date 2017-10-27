package br.com.fabricadeprogramador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fabricadeprogramador.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findByNomeIgnoreCase(String nome);

//	@Query("SELECT new Usuario(u.id, u.nome, u.senha) FROM Usuario u WHERE u.nome= :nome AND u.senha= :senha")
//    Usuario findByNomeAndSenha(@Param("nome") String nome, @Param("senha") String senha);
	
	List<Usuario> findByNomeAndSenha(String nome, String senha);
	    
    List<Usuario> findByPerfilDescricao(String descricao);

    List<Usuario> buscarPorPerfil(String descricaoPerfil );

//    List<Usuario> buscarPorEmail(String email);
    
    @Query("select new Usuario(u.id,u.nome, u.email) from Usuario u where u.perfil.id=?1")
    List<Usuario> findByPerfilId(Integer id);
}
