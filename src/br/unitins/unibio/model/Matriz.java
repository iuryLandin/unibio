package br.unitins.unibio.model;

import javax.persistence.Entity;

@Entity
public class Matriz extends Curso  {

	private static final long serialVersionUID = 4483146750507865164L;

	private Disciplina disciplina;

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	

}
