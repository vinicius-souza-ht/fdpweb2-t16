package br.com.fabricadeprogramador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity

@NamedQueries(
        {
                @NamedQuery(name = "Usuario.buscarPorPerfil", 
                		query = "select  new Usuario(u.id ,  u.nome, u.email)   from Usuario u where u.perfil.descricao= ?1")
        }
)
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "seq_usuario")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario")
	private Integer id;
	
	private String nome;
	private String email;
	private String senha;
	
	@JoinColumn
    @ManyToOne
	private Perfil perfil;

	// Construtor
	public Usuario() {
	}

	public Usuario(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
}
