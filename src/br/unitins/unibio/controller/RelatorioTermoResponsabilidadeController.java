package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Usuario;
import br.unitins.unibio.repository.UsuarioRepository;

@Named
@ViewScoped
public class RelatorioTermoResponsabilidadeController extends Controller<Usuario> {

	private static final long serialVersionUID = -1633567473515511522L;

	public RelatorioTermoResponsabilidadeController() {
		super(null);
		pesquisar();
	}


	private Usuario professor;
	private List<Usuario> listaProfessor = null;
	private String tema;
	private String periodo;

	public void imprimir() {
		Util.redirect("/UniBio/TermoDisponibilidade?USUARIO_CPF=" + getCpf() + "&PROFESSOR_NOME="
				+ getEntity().getNome() + "&PERIODO=" + getPeriodo() + "&TEMA=" + getTema());
	}

	public String getCpf() {
		return getUsuarioLogado().getCpf();
	}

	public List<Usuario> getListaProfessor() {
		if (listaProfessor == null)
			listaProfessor = new ArrayList<Usuario>();
		return listaProfessor;
	}

	public void pesquisar() {
		UsuarioRepository repository = new UsuarioRepository(getEntityManager());
		listaProfessor = repository.getUsuariosByType(1); // ira retornar apenas professores
	}

	public Usuario getProfessor() {
		if (professor == null)
			professor = new Usuario();
		return professor;
	}

	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
		}
		return entity;
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub

	}

}
