package br.unitins.unibio.relatoriocontroller;

import br.unitins.unibio.controller.Controller;
import br.unitins.unibio.controller.DefaultController;
import br.unitins.unibio.model.Usuario;
import br.unitins.unibio.repository.UsuarioRepository;
import br.unitins.unibio.validation.Validation;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Query;

@Named
@RequestScoped
public class TermoDisponibilidadeController extends Controller<Usuario> {

	public TermoDisponibilidadeController() {
		super(null);
		pesquisar();
	}

	private static final long serialVersionUID = 7071658971919994049L;
	private String[] diasSemana;
	private Usuario professor;
	private List<Usuario> listaProfessor = null;

	public void gerarRelatorio() {

	}

	public List<Usuario> getListaProfessor() {
		if (listaProfessor == null)
			listaProfessor = new ArrayList<Usuario>();
		return listaProfessor;
	}

	public void pesquisar() {
		UsuarioRepository repository = new UsuarioRepository(getEntityManager());
		listaProfessor =  repository.getUsuariosByType(1); //ira retornar apenas professores
	}

	public Usuario getProfessor() {
		if (professor == null)
			professor = new Usuario();
		return professor;
	}

	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}

	public String[] getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(String[] diasSemana) {
		this.diasSemana = diasSemana;
	}

	@Override
	public Usuario getEntity() {
		// TODO Auto-generated met hod stub
		return null;
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub

	}

}
