package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.unibio.model.Curso;
import br.unitins.unibio.model.Disciplina;
import br.unitins.unibio.model.Usuario;
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

	private Disciplina disciplina;

	public void adicionarDisciplina() {
		if (getEntity().getListaDisciplina() == null)
			getEntity().setListaDisciplina(new ArrayList<Disciplina>());

		// relacionando a disciplina com o curso
		getDisciplina().setCurso(getEntity());

		// adicionando a disciplina na lista
		getEntity().getListaDisciplina().add(getDisciplina());

		// limpando a disciplina depois da adicao
		setDisciplina(null);
	}

	public void removerDisciplina(Disciplina disciplina) {
		System.out.println(disciplina.getNome());
		getEntity().getListaDisciplina().remove(disciplina);
	}
	  

	@Override
	public Curso getEntity() {
		if (entity == null)
			entity = new Curso();
		return entity;
	}
	
	@Override
	public Curso incluir() {
		getEntity().setNome(entity.getNome());
		System.out.println(entity.getNome());
		return super.incluir();
	}
	
	@Override
	public Curso alterar() {
		//getEntity().setNome(entity.getNome());
		System.out.println(entity.getNome());
		return super.alterar();
	}

	@Override
	public void limpar() {
		setEntity(null);
		listaCurso = null;
		setDisciplina(null);
	}

	public List<Curso> getListaCurso() {
		if (listaCurso == null)
			listaCurso = new ArrayList<Curso>();
		return listaCurso;
	}

	public void pesquisar() {
		CursoRepository repository = new CursoRepository(getEntityManager());
		listaCurso = repository.getCursos("");
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Disciplina getDisciplina() {
		if (disciplina == null) {
			disciplina = new Disciplina();
		}
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Curso> getListaCursoAutoComplete(String nome) {
		CursoRepository repo = new CursoRepository(getEntityManager());
		return repo.getCursos(nome);
	}

	public void onItemSelect(SelectEvent event) {
		String curso = event.getObject().toString();
		getEntity().setNome(curso);
		setEntity( (Curso) event.getObject() );
	}

}
