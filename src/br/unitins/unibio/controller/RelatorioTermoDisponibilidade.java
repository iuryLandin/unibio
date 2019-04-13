package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Curso;
import br.unitins.unibio.model.Usuario;
import br.unitins.unibio.repository.CursoRepository;

@Named
@ViewScoped
public class RelatorioTermoDisponibilidade extends Controller<Usuario> {

	private static final long serialVersionUID = 8404891715790257033L;

	public RelatorioTermoDisponibilidade() {
		super(null);
		pesquisar();
	}

	private Curso curso;
	private String periodo;
	private List<Curso> listaCurso = null;
	private String[] diasSemana;

	public void imprimir() {
		Util.redirect("/UniBio/TermoDisponibilidade?USUARIO_CPF=" + getCpf() + "&CURSO_ID=" + getCurso().getId()
				+ "&PERIODO=" + getPeriodo() + "&DIA_SEMANA=" + diasSemana());
	}

	public String getCpf() {
		return getUsuarioLogado().getCpf();
	}

	public List<Curso> getListaCurso() {
		if (listaCurso == null)
			listaCurso = new ArrayList<Curso>();
		return listaCurso;
	}
	
 
	public void pesquisar() {
		CursoRepository repository = new CursoRepository(getEntityManager());
		listaCurso = repository.getCursos();  
	}

	public Curso getCurso() {
		if (curso == null)
			curso = new Curso();
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String[] getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(String[] diasSemana) {
		this.diasSemana = diasSemana;
	}
	
	public String diasSemana() {
		String str = "";
		 for(Object o : getDiasSemana()) {
	            String s = (String) o;
	            str += s + ", ";
	        }
		return str;
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
