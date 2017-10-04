package br.com.fabricadeprogramador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricadeprogramador.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findByNomeIgnoreCase(String nome);

    List<Usuario> findByNomeAndSenha(String nome, String senha);
}
