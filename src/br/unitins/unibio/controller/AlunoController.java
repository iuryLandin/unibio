package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.model.Aluno;
import br.unitins.unibio.repository.AlunoRepository;
import br.unitins.unibio.validation.Validation;

@Named
@ViewScoped
public class AlunoController extends Controller<Aluno> {
 
	public AlunoController(Validation<Aluno> validation) {
		super(validation);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -6865687347822474219L;
	
	private List<Aluno> listaAluno = null;
	private String pesquisa;
	

	@Override
	public Aluno getEntity() {
		if(entity == null)
			entity = new Aluno();
		return entity;
	}

	@Override
	public void limpar() {
		setEntity(null);
		listaAluno = null;
	}
	

	public List<Aluno> getListaAluno() {
		if (listaAluno == null)
			listaAluno = new ArrayList<Aluno>();
		return listaAluno;
	}
	
	public void pesquisar() {
		AlunoRepository repository = new AlunoRepository(getEntityManager());
		listaAluno = repository.getAlunos(pesquisa);
	}
	
 
}
