package br.com.fabricadeprogramador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricadeprogramador.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNomeIgnoreCase(String nome);

}
