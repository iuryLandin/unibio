package br.unitins.unibio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Curso extends DefaultEntity<Curso> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -292446564714689523L;

	private String nome;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", orphanRemoval = true)
	private List<Disciplina> listaDisciplina;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

}
