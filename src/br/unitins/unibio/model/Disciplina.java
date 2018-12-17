package br.unitins.unibio.model;

import javax.persistence.Entity;

@Entity
public class Disciplina extends DefaultEntity<Disciplina> {

	private static final long serialVersionUID = 6372044712055785916L;

	private String nome;
	private int chDiaria;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getChDiaria() {
		return chDiaria;
	}
	public void setChSemanal(int chDiaria) {
		this.chDiaria = chDiaria;
	}

}
