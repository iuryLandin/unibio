package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Professor;
import br.unitins.unibio.model.TipoUsuario;
import br.unitins.unibio.repository.ProfessorRepository;

@Named
@ViewScoped
public class ProfessorController extends Controller<Professor> {
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1419338688699739056L;
	

	public ProfessorController() {
		super(null);
	}
	
	private String pesquisa;
	private List<Professor> listaProfessor = null;
	

	@Override
	public Professor incluir() {
		String senhaEncriptada = Util.encrypt(getEntity().getSenha());
		getEntity().setSenha(senhaEncriptada);
		
		return super.incluir();
	}
	
	@Override
	public Professor alterar() {
		String senhaEncriptada = Util.encrypt(getEntity().getSenha());
		getEntity().setSenha(senhaEncriptada);
		
		return super.alterar();
	}
	
	
	
	
	@Override
	public Professor getEntity() {
		if(entity == null)
			entity = new Professor();
		return entity;
	}

	@Override
	public void limpar() {
		setEntity(null);
		listaProfessor = null;
	}
	

	public List<Professor> getListaProfessor() {
		if (listaProfessor == null)
			listaProfessor = new ArrayList<Professor>();
		return listaProfessor;
	}
	
	public void pesquisar() {
		ProfessorRepository repository = new ProfessorRepository(getEntityManager());
		listaProfessor = repository.getProfessores(pesquisa);
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	

	public TipoUsuario[] getVetorTipoUsuario() {
		return TipoUsuario.values();
	}
	
	
}
