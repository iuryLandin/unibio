package br.unitins.unibio.model;

import javax.persistence.Entity;

@Entity
public class Curso extends DefaultEntity<Curso> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -292446564714689523L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
