package br.unitins.unibio.listcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.unitins.unibio.model.Curso;
import br.unitins.unibio.repository.CursoRepository;

@Named
@ViewScoped
public class CursoListController extends ListController {

	private static final long serialVersionUID = -2213175655321289456L;

	private String nome;

	private List<Curso> listaCurso;

	public List<Curso> getListaCurso() {
		if (listaCurso == null) {
			listaCurso = new ArrayList<Curso>();
		}
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public void pesquisar() {
		CursoRepository repository = new CursoRepository(getEntityManager());
		listaCurso = repository.getCursos(nome);
	}

	public void selecionar(Curso curso) {
		PrimeFaces.current().dialog().closeDynamic(curso);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
