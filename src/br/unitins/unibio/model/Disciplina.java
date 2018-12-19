package br.unitins.unibio.model;

import javax.persistence.Entity;

@Entity
public class Disciplina extends DefaultEntity<Disciplina> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -292446564714689523L;
	
	private String nome;
	private Integer cargaHoraria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	
}
