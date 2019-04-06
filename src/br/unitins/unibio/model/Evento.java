package br.unitins.unibio.model;

import javax.persistence.Entity;

@Entity
public class Evento extends DefaultEntity<Evento> {

	private static final long serialVersionUID = 4579346599591488861L;

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
