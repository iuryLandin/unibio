package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.model.Curso;
import br.unitins.unibio.repository.CursoRepository;

@Named
@ViewScoped
public class CursoController extends Controller<Curso> {
 
	private static final long serialVersionUID = -6865687347822474219L;
	
	public CursoController() {
		super(null);
	}
	
	private String pesquisa;
	private List<Curso> listaCurso = null;
	

	@Override
	public Curso getEntity() {
		if(entity == null)
			entity = new Curso();
		return entity;
	}

	@Override
	public void limpar() {
		setEntity(null);
		listaCurso = null;
	}
	

	public List<Curso> getListaCurso() {
		if (listaCurso == null)
			listaCurso = new ArrayList<Curso>();
		return listaCurso;
	}
	
	public void pesquisar() {
		CursoRepository repository = new CursoRepository(getEntityManager());
		listaCurso = repository.getCursos(pesquisa);
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	
}
