package br.com.fabricadeprogramador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Perfil {
    
	@Id
    @SequenceGenerator(name ="seq_perfil", sequenceName = "seq_perfil")
    @GeneratedValue(generator = "seq_perfil")
    private Integer id;

    private String descricao;
}