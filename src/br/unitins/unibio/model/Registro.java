package br.unitins.unibio.model;

import javax.persistence.Entity;

@Entity
public class Registro extends DefaultEntity<Registro> {

	private static final long serialVersionUID = -826144251430323374L;

	private String data;
	private String hora;
	private Integer dia;
	private Integer aluno;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}

}
