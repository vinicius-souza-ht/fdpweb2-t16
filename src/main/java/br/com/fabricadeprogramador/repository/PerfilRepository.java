package br.com.fabricadeprogramador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricadeprogramador.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
}