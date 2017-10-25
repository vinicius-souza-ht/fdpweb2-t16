package br.com.fabricadeprogramador.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


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

//	@JsonIgnore
	private String senha;
	
	@JoinColumn
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Perfil perfil;

	// Construtor
	public Usuario() {
	}

	public Usuario(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
}
