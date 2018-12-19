package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.model.Disciplina;
import br.unitins.unibio.repository.DisciplinaRepository;

@Named
@ViewScoped
public class DisciplinaController extends Controller<Disciplina> {
 
	private static final long serialVersionUID = -6865687347822474219L;
	
	public DisciplinaController() {
		super(null);
	}
	
	private String pesquisa;
	private List<Disciplina> listaDisciplina = null;
	

	@Override
	public Disciplina getEntity() {
		if(entity == null)
			entity = new Disciplina();
		return entity;
	}

	@Override
	public void limpar() {
		setEntity(null);
		listaDisciplina = null;
	}
	

	public List<Disciplina> getListaDisciplina() {
		if (listaDisciplina == null)
			listaDisciplina = new ArrayList<Disciplina>();
		return listaDisciplina;
	}
	
	public void pesquisar() {
		DisciplinaRepository repository = new DisciplinaRepository(getEntityManager());
		listaDisciplina = repository.getDisciplinas(pesquisa);
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	
}
