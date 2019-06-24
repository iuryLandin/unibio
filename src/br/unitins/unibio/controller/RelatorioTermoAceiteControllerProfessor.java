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
public class RelatorioTermoAceiteControllerProfessor extends Controller<Usuario> {

	public RelatorioTermoAceiteControllerProfessor() {
		super(null);
		pesquisar();
	}

	private static final long serialVersionUID = -256630175017636901L;

	private Usuario aluno;
	private List<Usuario> listaAluno = null;

	public void imprimir() {
		Util.redirect("/UniBio/TermoAceite?USUARIO_CPF=" + getEntity().getCpf() + "&PROFESSOR_NOME=" + getProfNome());
	}

	public String getCpf() {
		return getUsuarioLogado().getCpf();
	}
	
	public String getProfNome() {
		return getUsuarioLogado().getNome();
	}

	public List<Usuario> getListaAluno() {
		if (listaAluno == null)
			listaAluno = new ArrayList<Usuario>();
		return listaAluno;
	}

	public void pesquisar() {
		UsuarioRepository repository = new UsuarioRepository(getEntityManager());
		listaAluno = repository.getUsuariosByType(3); // ira retornar apenas alunos
	}

	public Usuario getAluno() {
		if (aluno == null)
			aluno = new Usuario();
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
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
