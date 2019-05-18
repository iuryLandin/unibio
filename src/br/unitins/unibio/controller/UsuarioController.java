package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FlowEvent;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Disciplina;
import br.unitins.unibio.model.Endereco;
import br.unitins.unibio.model.TipoUsuario;
import br.unitins.unibio.model.Usuario;
import br.unitins.unibio.repository.DisciplinaRepository;
import br.unitins.unibio.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> {

	private static final long serialVersionUID = -6865687347822474219L;

	public UsuarioController() {
		super(null);

	}

	private String pesquisa;
	private String pesquisaDisciplina;
	private List<Usuario> listaUsuario = null;
	private List<Disciplina> listaDisciplinaLocal = null;
	private Endereco endereco;
	private Disciplina disciplina;

	private boolean skip;

	public void vincularDisciplina() {
		if (getEntity().getListaDisciplina() == null)
			getEntity().setListaDisciplina(new ArrayList<Disciplina>());

		// relacionando a disciplina com o usuario
		getDisciplina().setUsuario(getEntity());

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
	public Usuario incluir() {
		getEntity().setEndereco(getEndereco());
		// SENHA PADRÃO DA INCLUSAO É 123456
		String senhaEncriptada = Util.encrypt("123456");
		getEntity().setSenha(senhaEncriptada);
		return super.incluir();
	}

	@Override
	public Usuario alterar() {
		getEntity().setEndereco(getEndereco());
		return super.alterar();
	}

	public Usuario resetarSenha() {
		// SENHA PADRÃO DO RESET É 123456
		String senhaEncriptada = Util.encrypt("123456");
		getEntity().setSenha(senhaEncriptada);
		return super.alterar();
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
		setEntity(null);
		listaUsuario = null;
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null)
			listaUsuario = new ArrayList<Usuario>();
		return listaUsuario;
	}

	public List<Disciplina> getListaDisciplinaLocal() {
		if (listaDisciplinaLocal == null)
			listaDisciplinaLocal = new ArrayList<Disciplina>();
		return listaDisciplinaLocal;
	}

	public void pesquisar() {
		UsuarioRepository repository = new UsuarioRepository(getEntityManager());
		listaUsuario = repository.getUsuarios(pesquisa);
	}

	public void pesquisarDisciplina() {
		DisciplinaRepository repository = new DisciplinaRepository(getEntityManager());
		listaDisciplinaLocal = repository.getDisciplinas(pesquisaDisciplina);
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public String getPesquisaDisciplina() {
		return pesquisaDisciplina;
	}

	public void setPesquisaDisciplina(String pesquisaDisciplina) {
		this.pesquisaDisciplina = pesquisaDisciplina;
	}

	public TipoUsuario[] getVetorTipoUsuario() {
		return TipoUsuario.values();
	}

	public Endereco getEndereco() {
		if (endereco == null)
			endereco = new Endereco();
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

}