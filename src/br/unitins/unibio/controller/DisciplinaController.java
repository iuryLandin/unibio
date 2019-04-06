package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.unitins.unibio.model.Curso;
import br.unitins.unibio.model.Disciplina;
import br.unitins.unibio.repository.CursoRepository;
import br.unitins.unibio.repository.DisciplinaRepository;

@Named
@ViewScoped
public class DisciplinaController extends Controller<Disciplina> {

	private static final long serialVersionUID = -6865687347822474219L;

	private List<Curso> listaCurso = null;

	public DisciplinaController() {
		super(null);
	}

	private String pesquisa;
	private List<Disciplina> listaDisciplina = null;

	@Override
	public Disciplina getEntity() {
		if (entity == null)
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

	public void abrirListagemCurso() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", false); // nao permite redimencionar
		options.put("draggable", false); // nao permite arrastar
		options.put("modal", true); // abrir como modal
		options.put("width", "80%");
		options.put("height", "500");
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		PrimeFaces.current().dialog().openDynamic("listagemcurso", options, null);
	}

	public void cursoSelecionado(SelectEvent event) {
		Curso c = (Curso) event.getObject();
		entity.setCurso(c);
	}

	public List<Curso> getListaCurso() {
		if (listaCurso == null) {
			CursoRepository repo = new CursoRepository(getEntityManager());
			listaCurso = repo.getCursos("");
		}
		return listaCurso;
	}


}
