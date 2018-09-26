package br.com.senai.fatesg.faceTrainer.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cobaia {

	
	@Id
	   @GeneratedValue(generator="cobaia_seq", strategy=GenerationType.SEQUENCE)
	   @SequenceGenerator(name="cobaia_seq", sequenceName="cobaia_seq", allocationSize=1, initialValue=1)
	private Integer id;

	private String nome; 
	
	private String sobreNome;
	
	private String email;

	
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

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
	public Integer getId() {
		return id;
	}
	

}
