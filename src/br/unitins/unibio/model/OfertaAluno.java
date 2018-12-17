package br.unitins.unibio.model;

import javax.persistence.Entity;

@Entity

public class OfertaAluno extends Matriz {

	private static final long serialVersionUID = 9136717657463246397L;
	
	private Aluno aluno;
	private Semestre semestre;
	 
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Semestre getSemestre() {
		return semestre;
	}
	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	
	
	

}
