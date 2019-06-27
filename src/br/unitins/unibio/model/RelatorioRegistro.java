package br.unitins.unibio.model;

import javax.persistence.Entity;

@Entity
public class RelatorioRegistro extends DefaultEntity<RelatorioRegistro> {

	private static final long serialVersionUID = -6985078220433384023L;

	private String data;
	private String dia;
	private String entrada;
	private String saida;
	private String disciplina;
	private String matricula;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
}
