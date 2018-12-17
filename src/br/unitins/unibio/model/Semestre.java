package br.unitins.unibio.model;

import javax.persistence.Entity;

@Entity
public class Semestre extends DefaultEntity<Semestre> {

	private static final long serialVersionUID = -1624793536622087305L;

	private int ativo;
	private String nome;
	
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
 
	
	

}
