package br.unitins.unibio.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Disciplina extends DefaultEntity<Disciplina> {


	private static final long serialVersionUID = -292446564714689523L;

	private String nome;
	private Integer chTeorica;
	private Integer chPratica;
	private Integer chTotal;
	private String turma;
	private String ementa;
	
	@ManyToOne
	@JoinColumn(name="idCurso") 
	private Curso curso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getChTeorica() {
		return chTeorica;
	}

	public void setChTeorica(Integer chTeorica) {
		this.chTeorica = chTeorica;
	}

	public Integer getChPratica() {
		return chPratica;
	}

	public void setChPratica(Integer chPratica) {
		this.chPratica = chPratica;
	}

	public Integer getChTotal() {
		return chTotal;
	}

	public void setChTotal(Integer chTotal) {
		this.chTotal = chTotal;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
