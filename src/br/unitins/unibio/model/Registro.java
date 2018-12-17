package br.unitins.unibio.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Registro extends DefaultEntity<Registro> {

	private static final long serialVersionUID = 898170395879632157L;

	private Date data;
	private Date entrada;
	private Date saida;
	private OfertaAluno ofertaAluno;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public OfertaAluno getOfertaAluno() {
		return ofertaAluno;
	}

	public void setOfertaAluno(OfertaAluno ofertaAluno) {
		this.ofertaAluno = ofertaAluno;
	}

}
