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
public class RelatorioTermoAceiteController extends Controller<Usuario> {

	public RelatorioTermoAceiteController() {
		super(null);
		pesquisar();
	}

	private static final long serialVersionUID = -256630175017636901L;

	private Usuario professor;
	private List<Usuario> listaProfessor = null;

	public void imprimir() {
		Util.redirect("/UniBio/TermoAceite?USUARIO_CPF=" + getCpf() + "&PROFESSOR_NOME=" + getEntity().getNome());
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
