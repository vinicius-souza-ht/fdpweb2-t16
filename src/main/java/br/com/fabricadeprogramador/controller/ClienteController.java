package br.com.fabricadeprogramador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.repository.ClienteRepository;

@RestController
@RequestMapping("/clicontroller")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;

	@PostMapping
	public Cliente inserir(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping
	public Cliente alterar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Long id) {
		clienteRepository.delete(id);
	}
	
	@GetMapping
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable("id") Long id) {
		return clienteRepository.findOne(id);
	}
	
	@GetMapping("/{nome}")
	public List<Cliente> buscarPorNome(@PathVariable("nome")String nome){
		return clienteRepository.findByNomeIgnoreCase(nome);
	}
	
}
